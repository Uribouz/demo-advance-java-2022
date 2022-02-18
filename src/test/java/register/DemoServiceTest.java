package register;

import static org.junit.jupiter.api.Assertions.*;

//การ Mock Service test ทำได้ สอง แบบ
class DemoServiceTest {
    @Test
    @DisplayName("Get result 2 from input 1.")
    void case_01() {
        DB db = new DB() {
            @Override
            int increaseOne(int id) {
                return 2;
            }
        };
        DemoService demoService = new DemoService(db);
        String actualResult = demoService.compute(1);
        assertEquals("Result = 2", actualResult);
    }



    @Test
    @DisplayName("Get result 3 from input 2.")
    void case_02() {
        DB db = new DBX();
        DemoService demoService = new DemoService(db);
        String actualResult = demoService.compute(2s);
        assertEquals("Result = 3", actualResult);
    }
}

class DBX extends DB {
    @Override
    int increaseOne(int id) {
        return 3;
    }
}