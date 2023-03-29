import { MessageProcessor } from "./service/messageProcessor";

const WebSocket = require('ws');

const http = require('http')

const port = 3001;

export class WebSocketConfig {
    private messageProccessor: MessageProcessor;
    public constructor(messageProccessor: MessageProcessor) {
        this.messageProccessor = messageProccessor
        const server = http.createServer();
        const wss = new WebSocket.Server({ server })

        wss.on('connection', (ws: any) => {
            console.log("Connection Recived => ",ws);
            ws.on('message', async (message: any) => {
                console.log("data Recevicd => ", message.toString());
                var msg = message.toString().split("=");
                if (msg.length == 2) {
                    await this.processMessage(msg[0], msg[1]);
                } else{
                    ws.send("Invalid message allowed format => key=value");
                }
            })
        })
        server.listen(port, function () {
            console.log(`Websocket is listening on ${port}!`)
        })
    }
    
    public async processMessage(key: String, value: String) {
        await this.messageProccessor.insertKeyValue(key, value);
    }
}