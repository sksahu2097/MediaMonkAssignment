import { DatabaseConfig } from "./databseConfig";

export class MessageDao {
    private databaseconfig;
    constructor() {
        this.databaseconfig = new DatabaseConfig();
    }

    public async getValueByKey(key: String): Promise<any> {
        return await this.databaseconfig.fireQuerry("SELECT value FROM message where key='" + key + "'");
    }

    public async insertKeyValue(key: String, value:String) {
        await this.databaseconfig.fireQuerry("insert into message(key, value) values('"+key+"','"+value+"');");
    }

}