const express = require('express')
const app = express()
const bodyParser = require('body-parser')
// const { nanoid } = require('nanoid')
// const {connection} = require('./data/database');
const router = require('./features/register/register');
const PORT = 8080

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    res.send('Hello World!')
})

// connection.connect(err => {
//     if(err){
//         console.error('Error connecting to MySQL:', err)
//         return;
//     }
//     console.log('Connected to MySQL database')
// })

app.use('/', router)
// app.post('/user', (req, res)=>{
//     const userId = nanoid(16)
//     const {username, email, password} = req.body
//     const query = 'INSERT INTO batiqu_users_data (username, email, password, userId) VALUES (?, ?, ?, ?)'
//     const values = [username, email, password, userId]

//     connection.query(query, values, (err, result) => {
//         if(err){
//             console.error('An error occurred while inserting user data:', err)
//             res.status(500).send({message : 'There was a problem when adding user'})
//             return
//         }

//         console.log('User data insterted successfully');
//         res.status(200).send({message: 'User added successfully'})
//     })
// })

app.listen(PORT, () => {
    console.log(`Test app listening on port ${PORT}`)
})
