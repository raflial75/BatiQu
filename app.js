const express = require('express')
const app = express()
const bodyParser = require('body-parser')
const router = require('./features/register/register');
const PORT = 8080

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    res.send('Hello World!')
})

//Routing into register folder to do registration new users
app.use('/', router)

app.listen(PORT, () => {
    console.log(`Test app listening on port ${PORT}`)
})
