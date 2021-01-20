package com.dpapazikov.UserApplicationServer.Controller;

import com.dpapazikov.UserApplicationServer.Entity.Address;
import com.dpapazikov.UserApplicationServer.Entity.Person;
import com.dpapazikov.UserApplicationServer.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AddressController {

    private final AddressRepository addrRepo;
    @Autowired
    AddressController(AddressRepository repo)
    {
        this.addrRepo = repo;
    }

    @PostMapping("/address/{person_id}")
    public int addAddress(@PathVariable int person_id, @RequestBody Address addr)
    {
        addr.setPerson(new Person(person_id));
        return addrRepo.save(addr).getId();
    }

    @PutMapping("/address/{id}")
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

    @DeleteMapping("/address/{id}")
    public void removeAddress(@PathVariable int id)
    {
        addrRepo.deleteById(id);
    }
}
