/* eslint-disable linebreak-style */
/* eslint-disable max-len */
/* eslint-disable indent */
const db = require('../config/database');
/**
 * User Model Class
 */
class UserModel {
    /**
     * @param {string} username - Users Username
     * @param {string} email - Users Email
     * @param {string} password - Users Password
     * @param {Promise<number>} - ID of the newly registered user
     */
    async createUser(username, email, password) {
        const resultArray = await db.execute('INSERT INTO users (username, email, password, is_verified) VALUES (?, ?, ?, ?)', [
            username,
            email,
            password,
            false,
        ]);
        const result = resultArray[0];
        return result;
    }

    /**
     * Get a user by email from database
     * @param {string} username - Users username
     * @param {string} email - Users Email
     */
    async getUserByEmailORUsername(username, email) {
        console.log('Querying for username:', username, 'or email:', email);
        const users = await (await db).execute('SELECT * FROM users WHERE username = ? OR email = ?', [username, email]);
        console.log('Users from database:', users);
        return users.length > 0 ? users[0] : null;
    }

    /**
     * Update user verification in database
     * @param {string} email - User email
     * @param {boolean} isVerified - Whether the user is verified
     * @return {Promise<void>}
     */
    async updateUserVerificationStatus(email) {
        // Ensure userId is provided
        if (email === undefined || email === null) {
            throw new Error('Invalid email');
        }

        await db.execute('UPDATE users SET is_verified = true WHERE email = ?', [email]);
    }

    /**
     * Get user by email and password from the database
     * @param {string} email - User email
     * @param {string} password - User password
     * @return {Promise<Object|null>}
     */
    async getUserByEmailAndPassword(email, password) {
        try {
            const result = await db.execute('SELECT * FROM users WHERE email = ? AND password = ?', [email, password]);
            const users = Array.isArray(result) ? result[0] : [];
            return users[0];
        } catch (error) {
            console.error('Error executing query:', error);
            throw error; // or handle the error in an appropriate way
        }
    }
}

module.exports = new UserModel();
