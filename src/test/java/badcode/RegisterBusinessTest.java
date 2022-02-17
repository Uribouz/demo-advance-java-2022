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

    @Test
    @DisplayName("Last name = null ดังนั้นจะโยน exception ออกมา "+
            "พร้อมกับคำว่า Last name is required.")
    public void case03() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Ball");
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Last name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Email = null ดังนั้นจะโยน exception ออกมา "+
            "พร้อมกับคำว่า Email is required.")
    public void case03() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Ball");
        speaker.setLastName("Boba");
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Email is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Email ไม่อยู่ใน domains ดังนั้นจะโยน exception ออกมา "+
            "พร้อมกับคำว่า Speaker doesn't meet our standard rules.")
    public void case04() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Ball");
        speaker.setLastName("Boba");
        speaker.setEmail("ballboba@sanook.com");
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.",exception.getMessage());
    }

    @Test
    @DisplayName("Repository is null exception ออกมา "+
            "พร้อมกับคำว่า Can't save a speaker.")
    public void case05() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Ball");
        speaker.setLastName("Boba");
        speaker.setEmail("ballboba@gmail.com");
        Exception exception = assertThrows(SaveSpeakerException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Can't save a speaker.",exception.getMessage());
    }
}