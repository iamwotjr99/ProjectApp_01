const express = require('express');
const router = express.Router();
const dbPool = require('./dbConfig');

//Chatting Login
router.get('/get/user/:email/:password', (req, res) => {
    let email = req.params.email;
    let password = req.params.password;

    console.log(email, password);
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            return err;
        }

        let sql = 'SELECT * FROM user WHERE password = ? and email = ?';
    
        conn.query(sql, [password, email], (err, result) => {
            if(err) {
                err.code = 500;
                conn.release();
                return err;
            }
            
            res.send(result[0]);
            conn.release();
            console.log(result[0].user_ur_id);
            console.log('Get Success!');
        })
    })
});

//Chatting Join
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


// Cost Calender insert values
router.post('/post/calender', (req, res) => {
    let Month = req.body.Month;
    let Day = req.body.Day;
    let Cost = req.body.Cost;
    
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            console.log("error");
            return err;
        }
        let sql = 'INSERT INTO Calender (Month, Day, Cost) VALUES(?,?,?);'
        conn.query(sql, [Month, Day, Cost], (err, result) => {
            if(err) {
                err.code = 500;
                console.log("error");
                conn.release();
                return err;
            }

            conn.release();
            console.log(Month, Day, Cost);
            console.log('Post Success!');
        })
    })
});

//Cost Calener show values
router.get('/get/Calender/:Month/:Day/:Cost', (req, res) => {
    let Month = req.params.Month;
    let Day = req.params.Day;
    let Cost = req.params.Cost;

    console.log(Month, Day, Cost);
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            return err;
        }
        
        let sql = 'SELECT * FROM Calender WHERE Month = ? AND Day = ? AND Cost = ?';
    
        conn.query(sql, [Month, Day, Cost], (err, result) => {
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

module.exports = router;