# MediaMonkAssignment
Media Monk Assignment

This Assignment I have created a spring boot webservice where we can accept the message in the form of key=value pair and push that message into the database(Postgres SQL)
Technology used:-
  1. java
  2. spring boot
  3. websocket
  4. postgres SQL
  5. docker
  6. nodeJs
  7. typeScript
  
We have used docker for faster deployment we have created 2 containers for postgres, webservice.

Steps to install docker desktop (https://docs.docker.com/desktop/)

Steps to deploy:-
   1. git clone https://github.com/sksahu2097/MediaMonkAssignment.git
   2. cd MediaMonkAssignment
   3. docker-compose -f compose.yaml up

It will take few minutes and it will start.

steps to connect to websocket => (https://learning.postman.com/docs/sending-requests/websocket/websocket/)

API implemented to test Spring boot:-
 1. Get => localhost:8080/message-check/{key} =>  get the value by key
 2. websocket => localhost:8080/ws/message => connect over websocket
 
 
 API implemented to test Node Js:-
 1. Get => localhost:3000/message-check/{key} =>  get the value by key
 2. websocket => ws://localhost:3001 => connect over websocket
 
Steps to get into the postgress database

PS C:\Users\Santosh Sahu> docker exec -it media-monk-message-db bash

root@e949e70ecad2:/# psql -U admin

psql (15.1 (Debian 15.1-1.pgdg110+1))
Type "help" for help.

admin=# \d

List of relations

 Schema |      Name      |   Type   | Owner
--- | --- | --- | ---
public | message        | table    | admin
public | message_id_seq | sequence | admin


Implemented JUnit test case for the unit testing in the local.
