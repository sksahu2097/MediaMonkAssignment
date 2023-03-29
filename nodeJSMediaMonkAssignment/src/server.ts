
import { getMessage } from "./service/messageProcessor";

import { DatabaseConfig } from "./database/databseConfig";


var pg = require('pg');

const express = require("express");
const app = express();
const port = 3000;

// var conString = "postgres://admin:admin@database:5432/admin";

// var client = new pg.Client(conString);
// client.connect();
var db = new DatabaseConfig();

app.get("/message-check/:key", async (req:any, res:any) => {
  getMessage("Hello");

  var key = req.params.key;
  var query = await db.fireQuerry("SELECT value FROM message where key='"+key+"'");
//fired after last row is emitted
var obj ={};
if (query["rows"].length  > 0) {
  obj = {
    value : query["rows"][0]["value"]
  }
}
  res.send(obj);
});

app.listen(port, () => {
  console.log(`App started running on port ${port}!`);
});