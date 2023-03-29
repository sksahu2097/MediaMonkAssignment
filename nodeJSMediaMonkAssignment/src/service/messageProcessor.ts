import { MessageDao } from "../database/MessageDao";

export class MessageProcessor {
    private messageDao;
    public constructor() {
        this.messageDao = new MessageDao();
    }

    public  getValueByKey(key: String): any {
        return this.messageDao.getValueByKey(key).then(data => {
            if (data["rows"].length > 0) {
                return data["rows"][0]["value"];
            }
            throw new Error("Value Not found");
        })
    }

    public async insertKeyValue(key:String, value: String) {
        await this.messageDao.insertKeyValue(key, value);
    }
}