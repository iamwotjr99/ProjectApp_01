var express = require('express');
var socket = require('socket.io');

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
        console.log(data);
        socket.broadcast.emit('new message', data);
    })
})