/* eslint-disable linebreak-style */
/* eslint-disable indent */
const mysql = require('mysql2/promise');
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'Basisdata-my-sql-1st',
    database: 'new_schema',
    // port: 'port',
    // socketPath: 'socketPath',
});

module.exports = connection;
