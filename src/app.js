/* eslint-disable linebreak-style */
/**
 * @fileoverview Entry point for the Express application.
 */

const express = require('express');
const userRoutes = require('./routes/userRoutes');

/**
 * Express application instance
 * @type {express.Application}
 */
const app = express();

/**
 * Port which the server listening
 * @type {number}
 */
const port = 8080;

// Middleware to parse incoming JSON requests
app.use(express.json());

// Include user-related routes
app.use('/api', userRoutes);


/**
 * Start the server and listen on the specified port.
 */
async function startServer() {
  app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
  });
}

startServer();

debugger;

