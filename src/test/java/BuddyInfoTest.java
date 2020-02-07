import Spring.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    BuddyInfo buddy;
    BuddyInfo buddy2;
    BuddyInfo buddy3;

    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo();
        buddy2 = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNumber((long)6131234567.0);
        buddy3 = new BuddyInfo(buddy);
    }

    @Test
    public void getAddress() {
        assertEquals(buddy.getAddress(), "1125 Colonel By");
        assertEquals(buddy3.getAddress(), "1125 Colonel By");
    }

    @Test
    public void getName() {
        assertEquals(buddy.getName(), "Homer");
        assertEquals(buddy3.getName(), "Homer");
    }

    @Test
    public void getPhoneNumber() {
        assertEquals(buddy.getPhoneNumber(),  6131234567.0, 1.0);
        assertEquals(buddy3.getPhoneNumber(),  6131234567.0, 1.0);
    }

    @Test
    public void setAddress() {
        buddy2.setAddress("Wellington St");
        assertEquals(buddy2.getAddress(), "Wellington St");
    }

    @Test
    public void setName() {
        buddy2.setName("Albert");
        assertEquals(buddy2.getName(), "Albert");
    }

    @Test
    public void setPhoneNumber() {
        buddy2.setPhoneNumber((long)123456.0);
        assertEquals(buddy2.getPhoneNumber(),  123456.0, 1.0);
    }

}