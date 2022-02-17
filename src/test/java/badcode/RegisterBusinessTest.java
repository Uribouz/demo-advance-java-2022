package badcode;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

    @Test
    @DisplayName("ข้อมูล speaker = null จะโยน runtime exception กลัยมา " +
        "พร้อมกับ message speaker is null")
    public void case01() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            business.register(null,null);
        });
        assertEquals("speaker is null",exception.getMessage());
    }

    @Test
    @DisplayName("First name = null ดังนั้นจะโยน exception ออกมา "+
    "พร้อมกับคำว่า First name is required.")
    public void case02() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, new Speaker());
        });
        assertEquals("First name is required.",exception.getMessage());
    }
}