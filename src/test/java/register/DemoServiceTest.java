package register;

import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {
    @Test
    @DisplayName("Get result 2 from input 1.")
    void case_01() {
        DB db = new DBX();
        DemoService demoService = new DemoService(db);
        String actualResult = demoService.compute(1);
        assertEquals("Result = 2", actualResult);
    }
}

class DBX implements DB {
    @Override
    public int increaseOne(int id) {
        return 2;
    }
}