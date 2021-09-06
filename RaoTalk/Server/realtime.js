const app = require('express')();
const server = require('http').createServer(app);
const io = require('socket.io')(server);

let clients = [];

io.on('connection', (socket) => {
    clients.push(socket);
    console.log('a user connected');

    socket.on('send', (data) => {
        console.log("받은 메세지: " + data.message);
        data.message = "Message from Server : " + data.message;
        socket.emit('send', data)
    })
    socket.on('disconnect', () => {
        console.log('user disconnected');
        let i = clients.indexOf(socket);
        clients.splice(i, 1);
    })
});