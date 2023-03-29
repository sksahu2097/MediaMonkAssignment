const WebSocket = require('ws');

const http = require('http')

const port = 3001;

export class WebSocketConfig {
    public constructor() {
        const server = http.createServer();
        const wss = new WebSocket.Server({ server })

        wss.on('connection', function connection(ws: any) {
            ws.on('message', function incoming(data: any) {
                wss.clients.forEach(function each(client: any) {
                    if (client !== ws && client.readyState === WebSocket.OPEN) {
                        client.send(data);
                    }
                })
            })
        })
        server.listen(port, function () {
            console.log(`Websocket is listening on ${port}!`)
        })
    }
}