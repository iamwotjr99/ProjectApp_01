const express = require('express');
const router = express.Router();
const path = require('path');

router.get('/', serverTest);

router.get('/qgis2web', (req, res) => {
    res.sendFile(path.join(__dirname, '/qgis2web/index.html'));
})

router.get('/get/user/:email/:password', (req, res) => {
    let email = req.params.email;
    let password = req.params.password;

    console.log(email, password);
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            return err;
        }

        let sql = 'SELECT * FROM user WHERE password = ?';
    
        conn.query(sql, password, (err, result) => {
            if(err) {
                err.code = 500;
                conn.release();
                return err;
            }
            
            res.send(result[0]);
            conn.release();
            console.log(result[0]);
            console.log('Get Success!');
        })
    })
});

router.post('/post/user', (req, res) => {
    let name = req.body.name;
    let email = req.body.email;
    let password = req.body.password;
    
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            console.log("error");
            return err;
        }
        let sql = 'INSERT INTO user (name, email, password) VALUES(?,?,?);'
        conn.query(sql, [name, email, password], (err, result) => {
            if(err) {
                err.code = 500;
                console.log("error");
                conn.release();
                return err;
            }

            conn.release();
            console.log(name, email, password);
            console.log('Post Success!');
        })
    })
})

function serverTest(req, res) {
    res.send('Hello World!!');
}

module.exports = router;