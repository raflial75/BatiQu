const mysql  = require('mysql8')
const connection = mysql.createConnection({
    host        : 'localhost',
    user        : 'root',
    password    : 'Basisdata-my-sql-1st',
    database    : 'new_schema'
});

exports.connection = connection;