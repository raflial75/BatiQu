const express = require('express')
const router = express.Router()
const {nanoid} = require('nanoid')
const { connection } = require('../../data/database')

connection.connect(err => {
    if(err){
        console.error('Error connecting to MySQL:', err)
        return;
    }
    console.log('Connected to MySQL database')
})

router.post('/register', (req, res) => {
    const userId = nanoid(16)
    const {username, email, password} = req.body
    const query  = 'INSERT INTO batiqu_users_data (username, email, password, userId) VALUES (?, ?, ?, ?)'
    const values = [username, email, password, userId]

    connection.query(query, values, (err, result) => {
        if(err){
            console.error('An error occurred while inserting user data:', err)
            res.status(500).send({message : 'There was a problem when adding user'})
            return
        }

        console.log('User data insterted successfully');
        res.status(200).send({message: 'User added successfully'}) 
    })
})

module.exports = router;