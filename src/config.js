const crypto = require('crypto');

// Generate a secure random key
const secretKey = crypto.randomBytes(64).toString('hex');

console.log('Generated Secret Key:', secretKey);
