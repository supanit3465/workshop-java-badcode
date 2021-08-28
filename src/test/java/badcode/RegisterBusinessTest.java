package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {
    @Test
    @DisplayName("ไม่ทำการกำหนดชื่อ จะเกิด Exception: First name is required.")
    public void CaseNotAssignFirstName() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        try {
            registerBusinesses.register(null, new Speaker());
            fail();
        } catch (ArgumentNullException e) {
            if (!e.getMessage().equals("First name is required."))
                fail();
        }
    }

    @Test
    @DisplayName("ไม่ทำการกำหนดนามสกุล จะเกิด Exception: Last name is required.")
    public void Case2() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        try {
            Speaker request = new Speaker();
            request.setFirstName("Supanit");
            registerBusinesses.register(null, request);
            fail();
        } catch (ArgumentNullException e) {
            if (!e.getMessage().equals("Last name is required."))
                fail();
        }
    }

    @Test
    @DisplayName("ไม่ทำการกำหนดเมล จะเกิด Exception: Email is required.")
    public void Case3() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        try {
            Speaker request = new Speaker();
            request.setFirstName("Supanit");
            request.setLastName("Supait");
            registerBusinesses.register(null, request);
            fail();
        } catch (ArgumentNullException e) {
            if (!e.getMessage().equals("Email is required."))
                fail();
        }
    }

   @Test
    @DisplayName("ทำการกำหนดเมลผิดรูปแบบ จะเกิด Exception: Speaker doesn't meet our standard rules.")
    public void Case4() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        try {
            Speaker request = new Speaker();
            request.setFirstName("Supanit");
            request.setLastName("Supait");
            request.setEmail("oil@mail.com");
            registerBusinesses.register(null, request);
            fail();
        } catch (SpeakerDoesntMeetRequirementsException e) {
            if (!e.getMessage().equals("Speaker doesn't meet our standard rules."))
                fail();
        }
    }

    @Test
    @DisplayName("บักทึกไม่ได้ Exception: Can't save a speaker.")
    public void Case5() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        try {
            Speaker request = new Speaker();
            request.setFirstName("Supanit");
            request.setLastName("Supait");
            request.setEmail("oilspn@gmail.com");
            registerBusinesses.register(null, request);
            fail();
        } catch (SaveSpeakerException e) {
            if (!e.getMessage().equals("Can't save a speaker."))
                fail();
        }
    }

    @Test
    @DisplayName("บักทึกได้")
    public void case6() {
        RegisterBusiness registerBusinesses = new RegisterBusiness();
        Speaker request = new Speaker();
        request.setFirstName("Supanit");
        request.setLastName("Supait");
        request.setEmail("oilspn@gmail.com");
        int speakerId = registerBusinesses.register(new SpeakerRepositoryMock(), request);
        assertEquals(50,speakerId);
    }

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

class SpeakerRepositoryMock implements SpeakerRepository {
    @Override
    public Integer saveSpeaker(Speaker speaker) {
        return 50;
    }
}