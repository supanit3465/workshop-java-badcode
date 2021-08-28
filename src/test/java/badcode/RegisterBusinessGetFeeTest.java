package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessGetFeeTest {
    @Test
    @DisplayName("Fee 500")
    public void caseGetFee500() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        int fee = registerBusinesses.getFee(1);
        assertEquals(500,fee);
    }

    @Test
    @DisplayName("Fee 250")
    public void caseGetFee250() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        int fee = registerBusinesses.getFee(2);
        assertEquals(250,fee);
    }

    @Test
    @DisplayName("Fee 100")
    public void caseGetFee100() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        int fee = registerBusinesses.getFee(5);
        assertEquals(100,fee);
    }

    @Test
    @DisplayName("Fee 50")
    public void caseGetFee50() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        int fee = registerBusinesses.getFee(9);
        assertEquals(50,fee);
    }
}