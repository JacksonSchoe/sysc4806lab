import Spring.AddressBook;
import Spring.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    AddressBook addressBook;
    BuddyInfo buddy;
    BuddyInfo buddy3;

    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();
        buddy = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNumber((long)6131234567.0);
        buddy3 = new BuddyInfo(buddy);
    }

    @Test
    public void insert() {
        addressBook.insert(buddy);
        assertEquals(addressBook.getBuddyList().get(0).getName(), buddy.getName());
    }

    @Test
    public void remove() {
        addressBook.insert(buddy);
        assertEquals(addressBook.getBuddyList().get(0).getName(), buddy.getName());
        addressBook.remove(buddy);
        assertEquals(addressBook.getBuddyList().size(), 0);
    }

    @Test
    public void getAddressBook() {
        addressBook.insert(buddy);
        assertEquals(addressBook.getBuddyList().get(0).getName(), buddy.getName());
    }

    @Test
    public void setAddressBook() {
        AddressBook addressBook1 = new AddressBook();
        addressBook1.insert(buddy);
        addressBook.setBuddyList(addressBook1.getBuddyList());
        assertEquals(addressBook.getBuddyList().get(0).getName(), addressBook1.getBuddyList().get(0).getName());
    }
}