package Spring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {


    private Integer id = null;

    private List<BuddyInfo> buddyList;
    public AddressBook(){
        buddyList = new ArrayList<BuddyInfo>();
    }

    public void insert(BuddyInfo buddy) {
        buddyList.add(buddy);
        buddy.setAddressBook(this);
    }

    public void remove(BuddyInfo buddy) {
        buddyList.remove(buddy);
        buddy.setAddressBook(null);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressBook")
    public List<BuddyInfo> getBuddyList() {
        return buddyList;
    }

    public void setBuddyList(List<BuddyInfo> addressBook) {
        this.buddyList = addressBook;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String allBuddies = "";
        for(BuddyInfo buddy: buddyList){
            allBuddies += buddy.toString() + " ";
        }
        return allBuddies;
    }

    public static void main(String[] args){
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy = new BuddyInfo();
        buddy = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNumber((long)6131234567.0);
        addressBook.insert(buddy);
        BuddyInfo buddy2 = new BuddyInfo();
        buddy2 = new BuddyInfo();
        buddy2.setName("Frank");
        buddy2.setAddress("36 Avenue way");
        buddy2.setPhoneNumber((long)6137111111.0);
        addressBook.insert(buddy2);
        System.out.println(addressBook.toString());

    }


}