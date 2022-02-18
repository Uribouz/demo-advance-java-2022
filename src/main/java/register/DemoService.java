package register;

public class DemoService {
    DB db;

    public DemoService(DB db) {
        this.db = db;
    }

    public String compute(int id) {
        return "Result = " + db.increaseOne(id);
    }
}

class DB {
    int increaseOne(int id) {
        //return id + 1
        throw new RuntimeException("Under construction.");
    }
}
