package demo;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    @DisplayName("เรากำลังทดสอบเรื่องอะไร อย่างไร ไต้องด้อะไร")
    public void case01() {
        HelloWorld helloWorld = new HelloWorld();
        String actualResult = helloWorld.hi("ball");
        assertEquals("Hello ball", actualResult);
    }
}