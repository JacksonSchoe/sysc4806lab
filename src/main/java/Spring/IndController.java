package Spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndController {

    @Autowired
    private AddressBookRepository repo;

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("addressBooks", repo.findAll());
        return "index";
    }
}
