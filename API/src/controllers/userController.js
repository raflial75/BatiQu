/* eslint-disable linebreak-style */
/* eslint-disable max-len */
/* eslint-disable new-cap */
/* eslint-disable indent */

/**
 * @fileoverview User controller handling HTTP request related to user registration
 */

const express = require('express');
const userService = require('../services/userService');

/**
 * Express router for user-related routes
 * @type {express.Router}
 */
const router = express.Router();

/**
 * POST /api/users/register - Register new user
 * @param {express.Request} req - Express request object
 * @param {express.Response} res - Express response object
 */
router.post('/register', async (req, res) => {
    const {username, email, password} = req.body;

    try {
        const userId = await userService.registerUser(username, email, password);
        res.status(201).json({userId, message: 'User registered succesfully'});
    } catch (error) {
        console.error(error);
        res.status(400).json({error: error.message});
    };
});

/**
 * POST /api/users/verify - Verify user account by provided token
 * @param {express.Request} req - Express request object
 * @param {express.Response} res - Express response object
 */
router.get('/verify', async (req, res) => {
    const token = req.query.token;

    try {
        const email = await userService.verifyUser(token);

        if (email) {
            res.status(200).json({email, message: 'Account verified successfully'});
        } else {
            res.status(400).json({message: 'Failed to verify account. Invalid or expired token'});
        }
    } catch (error) {
        console.error(error);
        res.status(400).json({error: error.message});
    }
});

router.post('/login', async (req, res) => {
    const {username, email, password} = req.body;

    try {
        const userId = await userService.loginUser(username, email, password);

        if (userId) {
            res.status(200).json({userId, message: 'Login success'});
        } else {
            console.log('email: ', email);
            console.log('password: ', password);
            res.status(400).json({message: 'Login failed. Check your email and password'});
        }
    } catch (error) {
        console.error(error);
        res.status(400).json({error: error.message});
    }
});

module.exports = router;
