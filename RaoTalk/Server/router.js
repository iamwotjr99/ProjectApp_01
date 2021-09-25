const express = require('express');
const router = express.Router();
const path = require('path');

router.get('/', serverTest);

router.get('/qgis2web', (req, res) => {
    res.sendFile(path.join(__dirname, '/qgis2web/index.html'));
})

// 로그인
router.get('/get/user/:email/:password', (req, res) => {
    let email = req.params.email;
    let password = req.params.password;

    console.log(email, password);
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            return err;
        }

        let sql = 'SELECT * FROM user WHERE password = ? AND email = ?';
    
        conn.query(sql, [password, email], (err, result) => {
            if(err) {
                err.code = 500;
                conn.release();
                return err;
            }

            let resultData = {
                user_id: result[0].user_id,
                name: result[0].name,
                email: result[0].email,
                password: result[0].password,
                profile: result[0].profile
            }

            console.log(resultData.user_id);
            
            res.send(resultData);
            console.log(resultData);
            console.log('Get Login Success!');
            conn.release();
        })
    })
});

// 회원가입
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
            res.send(result);
            console.log('Post Success!');
        })
    })
})


// 프로필 사진 설정
router.put('/put/user/profile', (req, res) => {
    let email = req.body.email;
    let profile = req.body.profile;
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            console.log("error");
            return err;
        }
        let sql = 'UPDATE user SET profile=? WHERE email=?'
        conn.query(sql, [profile, email], (err, result) => {
            if(err) {
                err.code = 500;
                console.log("error");
                conn.release();
                return err;
            }

            conn.release();
            console.log(profile, email);
            res.send(result);
            console.log('Profile Put Success!');
        })
    })
})

// user_id를 통해서 친구데이터 가져오기
router.get("/get/user/:user_id", (req, res) => {
    let user_id = req.params.user_id;

    console.log(user_id);
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            console.log("error");
            return err;
        }

        let sql = "SELECT * from user WHERE user_id = ?";

        conn.query(sql, user_id, (err, result) => {
            if(err) {
                err.code = 500;
                console.log("error");
                conn.release();
                return err;
            }

            res.send(result[0]);
            console.log(result[0]);
            conn.release();
        })
    })
})

// 친구의 user_id를 통해서 friends 테이블에 친구 데이터 POST
router.post("/post/user/:user_id/add/:friend_id", (req, res) => {
    let user_id = req.params.user_id;
    let friend_id = req.params.friend_id;
    let friend_name = req.body.name;
    let friend_email = req.body.email;
    let friend_password = req.body.password;
    let frined_profile = req.body.profile;

    console.log(user_id, friend_id);

    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            console.log("error");
            return err;
        }

        let sql = "INSERT INTO friends (user_id, fr_name, fr_email, fr_password, fr_profile, friend_id) VALUES (?, ?, ?, ?, ?, ?)"

        conn.query(sql, [user_id, friend_name, friend_email, friend_password, frined_profile, friend_id], (err, result) => {
            if(err) {
                err.code = 500;
                console.log("error");
                conn.release();
                return err;
            }

            res.send(result);
            console.log("Post Friends Success!");
        })
    })
})

// user_id에 맞는 친구리스트 가져오기
router.get("/get/:user_id/friendsList", (req, res) => {
    let user_id = req.params.user_id;


    console.log(user_id);
    dbPool.getConnection((err, conn) => {
        if(err) {
            err.code = 500;
            console.log("error");
            return err;
        }

        let sql = "SELECT * FROM friends WHERE user_id = ?;"
       
        conn.query(sql, user_id, (err, result) => {
            if(err) {
                err.code = 500;
                console.log("error");
                conn.release();
                return err;
            }
        
            console.log(result);
            res.send(result);
            conn.release();
            
        })
    })
})

//캘린더 내용 설정
let costList = [];
router.post('/post/calendar/:cost/:memo', (req, res) => {
    let cost = req.params.cost;
    let memo = req.params.memo;
    console.log("Post: {cost}: ", cost, ", {memo}: ", memo);
    let result = {
        cost : cost,
        memo : memo
    }
    res.send(result);
    costList.push(result);
})

router.get('/get/calendar/:cost/:memo', (req, res) => {
    let cost = req.params.cost;
    let memo = req.params.memo;
    console.log("Get: {cost}: ", cost, ", {memo}: ", memo);
    let result = {
        cost : cost,
        memo : memo
    }
    res.send(costList);
    console.log(costList);
})

//채팅방 목록
router.post('/post/chatList/:title', (req, res) => {
    let title = req.params.title;
    console.log("Post: {title}", title);

    res.send(title);
})

router.get('/get/chatList/:title', (req, res) => {
    let title = req.params.title;
    console.log("Get: {title}", title);

    res.send(title);
})

function serverTest(req, res) {
    res.send('Hello World!!');
}

module.exports = router;