package Spring;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class BuddyInfo implements Serializable {

    private Integer id;
    private String address;
    private String name;
    private long phoneNumber;


    private AddressBook addressBook;

    public BuddyInfo(){
    }

    public BuddyInfo(String a, String name, long pN){
        this.address = a;
        this.name = name;
        this.phoneNumber = pN;
    }

    public BuddyInfo(BuddyInfo buddy){
        this.address = buddy.getAddress();
        this.name = buddy.getName();
        this.phoneNumber = buddy.getPhoneNumber();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToOne
    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "BuddyInfo: " +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'';
    }

    /*@Override
    public boolean equals(Object o) {
        if(!((b.getName().equals(this.getName()))&&(b.getAddress().equals(this.getAddress()))&&(b.getPhoneNumber()==(this.getPhoneNumber())))){
            return false;
        }
    }*/

    public static void main(String[] args){
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNumber((long)6131234567.0);
        System.out.println(buddy.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuddyInfo)) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return phoneNumber == buddyInfo.phoneNumber &&
                Objects.equals(address, buddyInfo.address) &&
                Objects.equals(name, buddyInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, name, phoneNumber);
    }
}
