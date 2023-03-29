
import { MessageProcessor } from "./service/messageProcessor";
import { WebSocketConfig } from "./websocketconfig";

const express = require("express");
const app = express();
const port = 3000;

var messageProcessor = new MessageProcessor();

app.get("/message-check/:key", async (req: any, res: any) => {
  var key = req.params.key;
  try {
    var data = await messageProcessor.getValueByKey(key);
    res.status(200).send(data);
  } catch (error) {
    res.status(400).send("value found");
    
  }
});

app.listen(port, () => {
  console.log(`App started running on port ${port}!`);
});

var WebSocket = new WebSocketConfig(messageProcessor);
