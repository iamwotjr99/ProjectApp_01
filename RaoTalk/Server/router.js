const express = require('express');
const router = express.Router();
const path = require('path');

router.get('/', serverTest);

router.get('/qgis2web', (req, res) => {
    res.sendFile(path.join(__dirname, '/qgis2web/index.html'));
})

function serverTest(req, res) {
    res.send('Hello World!!');
}

module.exports = router;