const express = require("express");
const app = express();
const port = 3000;

app.get("/message-check/:key", (req, res) => {
  res.send("Hello World! Hey = "+req.params.key);
});

app.listen(port, () => {
  console.log(`App started running on port ${port}!`);
});