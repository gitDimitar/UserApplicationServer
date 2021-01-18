package Controller;

import Entity.Address;
import Repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    private final AddressRepository addrRepo;

    AddressController(AddressRepository repo)
    {
        this.addrRepo = repo;
    }

    @PostMapping("/address")
    public int addAddress(@PathVariable int person_id, @RequestBody Address addr)
    {
        addr.setPerson(addrRepo.findPersonById(person_id));
        return addrRepo.save(addr).getId();
    }

    @PutMapping("/address")
    public void editAddress(@PathVariable int id, @RequestBody Address addr)
    {
        addrRepo.findById(id).map(a ->
        {
            a.setCity(addr.getCity());
            a.setPostCode(addr.getPostCode());
            a.setStreet(addr.getStreet());
            a.setState(addr.getState());
            return null;
        });
    }

    @DeleteMapping("/address")
    public void removeAddress(@PathVariable int id)
    {
        addrRepo.deleteById(id);
    }
}
