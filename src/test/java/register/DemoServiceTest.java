package register;

import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {
    @Test
    @DisplayName("Get result 2 from input 1.")
    void case_01() {
        DB dbStub = new DBX();
        DemoService demoService = new DemoService(dbStub);
        String actualResult = demoService.compute(1);
        assertEquals("Result = 2", actualResult);
    }

    @Test
    void case_spy() {
        DbSpy spy = new DbSpy();
        DemoService demoService = new DemoService(spy);
        String actualResult = demoService.compute(1);

        spy.verify(1);
    }
}

class DbSpy implements DB {
    private int count;
    public void verify(int count) {
        assertTrue(count == this.count, "Must called = " + count + " but called = " + this.count);
    }

    @Override
    public int increaseOne(int id) {
        //ถ้ามี Logic ตรงนนี้ object นี้จะเปลี่ยนจาก Spy --> Mock
        count++;
        return 200000;
    }
}
class DBX implements DB {
    @Override
    public int increaseOne(int id) {
        return 2;
    }
}