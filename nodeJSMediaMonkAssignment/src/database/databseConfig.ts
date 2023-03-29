var pg = require('pg');

export class DatabaseConfig {

    private client:any ;

    public constructor() {
        var conString = "postgres://admin:admin@database:5432/admin";
        this.client = new pg.Client(conString);
        this.client.connect();
        console.log("Node JS successfully connected to Database");
    }

    public fireQuerry(query: string): any {
        return this.client.query(query);
    }

}