var express = require('express');
var socket = require('socket.io');
const dbPool = require('./dbConfig');

var app = express();

app.use(express.static('public'));

var server = app.listen(5000);

var io = socket(server);

io.on('connection', (socket) => {
    console.log('made socket connection', socket.id);

    socket.on('chat', (data) => {
        console.log(data);
        io.socket.emit('chat', data);
    });

    // socket.on('typing', (data) => {
    //     socket.broadcast.emit('typing', data);
    // })

    // socket.on('stop typing', (data) => {
    //     socket.broadcast.emit('stop typing', data);
    // });

    socket.on('new message', (data) => {
        let user_id = data.user_id;
        let name = data.username;
        let message = data.message;

        console.log("메세지 데이터: ", data);

        dbPool.getConnection((err, conn) => {
            if(err) {
                err.code = 500;
                return err;
            }

            let sql = 'INSERT INTO msg (user_id, name, message) VALUES (?, ?, ?)'

            conn.query(sql, [user_id, name, message], (err, result) => {
                if(err) {
                    err.code = 500;
                    conn.release();
                    return err;
                }

                console.log("Post Success!");
            })
        })
        
        socket.broadcast.emit('new message', data);
    });
})