const express   = require('express')
const bcyript   = require ('bcrypt')
const router    = express.Router()

const { connection } = require('../../data/database')

//connect into database
connection.connect(err => {
    if(err){
        console.error('Error connecting to MySQL:', err)
        return;
    }
    console.log('Connected to MySQL database')
})

//send POST request to register new users
router.post('/register', (req, res) => {
    const saltRounds = 10
    const {username, email, password} = req.body
    
    //check the username or email that already in use
    const checkQuery = 'SELECT * FROM batiqu_users_data WHERE username = ? OR email = ?'
    connection.query(checkQuery, [username, email], (checkErr, checkResult) => {
        if(checkErr){
            console.error('An error occured while checking email/username', checkErr)
            return res.status(500).send({message : 'There was problem on internal server'})
        }

        if(checkResult.length > 0){
            console.log('user data already in use', checkResult)
            return res.status(409).send({message : 'Username or Email already in use'})
        }
        
        //hashing the password
        bcyript.hash(password, saltRounds, function(err, hash){
            const query     = 'INSERT INTO batiqu_users_data (username, email, password) VALUES (?, ?, ?)'
            const values    = [username, email, hash]
            
            //store new users data to database
            connection.query(query, values, (err, result) => {
                if(err){
                    console.error('An error occurred while inserting user data:', err)
                    res.status(500).send({message : 'There was a problem when adding user'})
                    return
                }
        
                console.log('User data inserted successfully')
                res.status(200).send({message: 'User added successfully'})
            })
        })
    })
})

module.exports = router;