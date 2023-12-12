/* eslint-disable linebreak-style */
/* eslint-disable new-cap */
/**
 * @fileoverview User-related routes
 */

const express = require('express');
const userController = require('../controllers/userController');

/**
 * Express router for user-related routes
 * @type {express.Router}
 */
const router = express.Router();

// User routes
router.use('/users', userController);

module.exports = router;
