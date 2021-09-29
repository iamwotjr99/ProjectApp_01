var express = require('express');
var socket = require('socket.io');
const dbPool = require('./dbconfig');

var app = express();

app.use(express.static('public'));

var server = app.listen(3000);

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
        socket.join(data.room_id);
        
        let user_id = data.user_id;
        let name = data.username;
        let message = data.message;
        let room_id = data.room_id;

        console.log("메세지 데이터: ", data);

        dbPool.getConnection((err, conn) => {
            if(err) {
                err.code = 500;
                return err;
            }

            let sql = 'INSERT INTO message (user_id, room_id, message) VALUES (?, ?, ?)'

            conn.query(sql, [user_id, room_id, message], (err, result) => {
                if(err) {
                    err.code = 500;
                    conn.release();
                    return err;
                }

                console.log("Post Success!");
            })
        })
        
        socket.broadcast.to(data.room_id).emit("new message", data);
    })
})