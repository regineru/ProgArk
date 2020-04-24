const app = require('express')()
const server = require('http').Server(app)
const io = require('socket.io')(server)
let players = []

server.listen(8080, () => {
    console.log('Server is now running...')
})

io.on('connection', socket => {
    console.log('player connected')
    socket.emit('socketID', { id: socket.id })
    socket.broadcast.emit('newPlayer', {id: socket.id})
    socket.on('disconnect', () => {
        console.log('player disconnected'))
        socket.broadcast.emit('playerDisconnected', { id: socket.id})
        for(let i = 0; i < players.length; i++) {
            if (players[i].id === socket.id) {
                players.splice(i, 1)
            }
        }
    }
    players.push(new player(socket.id, 0, 0))
})

const player = (id, x, y) => {
    this.id = id
    this.x = x
    this.y = y
}
