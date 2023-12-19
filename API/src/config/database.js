/* eslint-disable linebreak-style */
/* eslint-disable indent */
require('dotenv').config()

const mysql = require('mysql2/promise');
const connection = mysql.createConnection({
    host: 'PUBLIC_IP_ADRRESS',
    user: 'USER',
    password: 'PASSWORD',
    database: 'DATABASE',
    port: 'PORT',
    socketPath: 'SOCKET_PATH',
});

module.exports = connection;
