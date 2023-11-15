// const express = require('express')
// const app = express()
// const connection = require('../data/connections')
// const PORT = 8080

// app.get('/', (req, res) => {
//     res.send('Hello World!')
// })

// connection.connect(err => {
//     if(err){
//         console.error('Error connecting to MySQL:', err)
//         return;
//     }
//     console.log('Connected to MySQL database')
// })

// app.post('/user', (req, res)=>{
//     const {username, email, password} = req.body
//     const query = 'INSERT INTO users (name, email, password) VALUES (?, ?, ?)'
//     const values = [username, email, password]

//     connection.query(query, values, (err, result) => {
//         if(err){
//             console.err('Error inserting user data:', err)
//             res.status(500).send({message : 'Error adding user'})
//             return
//         }

//         console.log('User data insterted successfully');
//         res.status(200).send({message: 'User added successfully'})
//     })
// })

// app.listen(PORT, () => {
//     console.log(`Test app listening on port ${PORT}`)
// })
