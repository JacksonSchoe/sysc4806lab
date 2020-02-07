package Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Autowired
    private AddressBookRepository repo;

    @Autowired
    private BuddyInfoRepository buddyInfoRepo;

    @PostMapping("/createAddressBook")
    public AddressBook createAddressBook(){
        AddressBook addressBook = new AddressBook();

        repo.save(addressBook);

        return addressBook;
    }


    //localhost:8080/addBuddy?id=4&name="joe"&address="street"&phoneNumber=123
    @PostMapping("/addBuddy")
    public BuddyInfo addBuddy(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNumber") long pN){

        BuddyInfo buddy = new BuddyInfo(address, name, pN);

        AddressBook addressBook = repo.findById(id);

        addressBook.insert(buddy);

        repo.save(addressBook);

        return buddy;
    }

    //localhost:8080/removeBuddy?id=4&name="joe"&address="street"&phoneNumber=123
    @DeleteMapping("/removeBuddy")
    public BuddyInfo removeBuddy(@RequestParam("id") Integer id){
        BuddyInfo buddy = buddyInfoRepo.findById(id);
        buddy.getAddressBook().remove(buddy);
        buddyInfoRepo.delete(buddy);
        return buddy;
    }
}
