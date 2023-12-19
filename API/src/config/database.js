/* eslint-disable linebreak-style */
/* eslint-disable indent */
require('dotenv').config()

const mysql = require('mysql2/promise');
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'Basisdata-my-sql-1st',
    database: 'new_schema',
    // port: process.env.DB_PORT,
    // socketPath: process.env.DB_SCKT,
});

module.exports = connection;
