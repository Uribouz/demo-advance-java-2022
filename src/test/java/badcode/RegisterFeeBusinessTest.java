package badcode;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFeeBusinessTest {

    @ParameterizedTest
    @CsvSource({
            "0,500",
            "1,500",
            "2,250",
            "9,50",
            "10,50",
    })
    void getFee(int expYear, int expectedFee) {
        RegisterBusiness business = new RegisterBusiness();
        int actualFee = business.getFee(expYear);
        assertEquals(expectedFee, actualFee);
    }

}