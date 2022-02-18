package register;

public class DemoService {
    public String compute(int id) {
        DB db = new DB();
        return "Result = " + db.increaseOne(id);
    }
}

class DB {
    int increaseOne(int id) {
        //return id + 1
        throw new RuntimeException("Under construction.");
    }
}
