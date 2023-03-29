
import { getMessage } from "./service/messageProcessor";

import { DatabaseConfig } from "./database/databseConfig";
import { WebSocketConfig } from "./websocketconfig";

const express = require("express");
const app = express();
const port = 3000;

var db = new DatabaseConfig();


app.get("/message-check/:key",  async (req:any, res:any) => {
  getMessage("Hello");

  var key = req.params.key;
  var query = await db.fireQuerry("SELECT value FROM message where key='"+key+"'");
//fired after last row is emitted
var obj ={
  value : "no data found"
};
if (query["rows"].length  > 0) {
  obj['value'] =  query["rows"][0]["value"];
}
  res.send(obj);
});

app.listen(port, () => {
  console.log(`App started running on port ${port}!`);
});

var WebSocket = new WebSocketConfig();
