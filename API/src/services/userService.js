/* eslint-disable linebreak-style */
/* eslint-disable indent */
/* eslint-disable max-len */
require('dotenv').config();
/**
 * @fileoverview Users service handling business logic related to user registration
 */

const userModel = require('../models/userModel');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const nodemailer = require('nodemailer');

/**
 * User service class
 */
class UserService {
    /**
     * Password requirements
     * @param {string} password - User password 
     */
    validatePassword(password){
        // Password must be at least 8 characters long
        if (password.length < 8) {
            throw new Error('Password must be at least 8 characters long');
        }

        // Password must contain at least one uppercase letter
        if (!/[A-Z]/.test(password)) {
            throw new Error('Password must contain at least one uppercase letter');
        }

        // Password must contain at least one lowercase letter
        if (!/[a-z]/.test(password)) {
            throw new Error('Password must contain at least one lowercase letter');
        }

        // Password must contain one digit number
        if (!/\d/.test(password)) {
            throw new Error('Password must contain one digit number');
        }

        // Password must contain at least one special character
        if (!/[!@#$%^_&-*]/.test(password)) {
            throw new Error('Password must contain at least one special character ("!, @, #, $, %, ^, _, &, -, *")');
        }
    }

    /**
     * @param {string} username - Users Username
     * @param {string} email - Users Email
     * @param {string} password - Users Password
     * @return {Promise<number>} - ID of the newly registered user
     * @throws {Error} - Throw an error
     */
    async registerUser(username, email, password) {
        //validate the password
        this.validatePassword(password);
        // Hash the password
        const hashedPassword = await bcrypt.hash(password, 10);

        // check the email in database
        const existingUser = await userModel.getUserByEmailORUsername(username, email);
        try {
            if (existingUser) {
                console.log('email:', email);
                console.log('username', username);
                throw new Error('Email or Username already in use');
            }
        } catch (error) {
            console.error(error.message);
        }

        // register user in database
        const userId = await userModel.createUser(username, email, hashedPassword);

        await this.sendVerificationEmail(email, userId);

        return userId;
    };

    /**
     * Send verification email to user
     * @param {string} email - User email
     * @param {number} userId - User ID
     */
    async sendVerificationEmail(email, userId) {
        // Create a JWT token with the user ID
        const token = jwt.sign({email}, process.env.SECRET_KEY, {expiresIn: '900s'});

        // This line used for debugging
        // console.log('Generated token:', token);
        // console.log('user email before creating token: ', email);
        // console.log('UserId before creating token:', userId);

        // Configure nodemailer for sending emails
        const transporter = nodemailer.createTransport({
            service: 'gmail',
            auth: {
                user: process.env.EMAIL,
                pass: process.env.PASS,
            },
            logger: false,
        });

        const mailOptions = {
            from: process.env.EMAIL,
            to: email,
            subject: 'Verify Your Account',
            html: `<p>Click the following link to verify your account: <a href="your_url/api/users/verify?token=${token}">Verify</a></p>`,
        };

        await transporter.sendMail(mailOptions);
    }

    /**
     * Verifies user based on the JWT token
     * @param {string} token - JWT token
     * @return {Promise<string|null>} - ID of the verified user or null if verification fails
     */
    async verifyUser(token) {
        try {
            const decoded = jwt.verify(token, process.env.SECRET_KEY);
            const email = decoded.email;

            // This lines used for debugging
            // console.log('Decoded token:', decoded);
            // console.log('Extracted email:', email);

            if (email === undefined || email === null) {
                throw new Error('Invalid userId');
            }

            await userModel.updateUserVerificationStatus(email);
            return email;
        } catch (error) {
            console.error(error);
            return null; // verification failed
        }
    }

    /**
     * Logs in a user.
     * @param {string} username - User username
     * @param {string} email - User email
     * @param {string} password - User password
     * @return {Promise<number|null>} - ID of the logged-in user or null
     */
    async loginUser(username, email, password) {
        console.log('Login attempt with username:', username, 'or email:', email);
        // Get user by email
        const [user] = await userModel.getUserByEmailORUsername(username, email);

        if (user) {
            console.log('User Object:', user);
          } else {
            console.log('User not found');
        }

        // Check if the user exist and compare the password
        if (user && (await bcrypt.compare(password, user.password)) && user.is_verified) {
            return user.id;
        } else {
            return null; // Login failed
        }
    }
};

module.exports = new UserService();
