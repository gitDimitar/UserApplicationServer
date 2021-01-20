package com.dpapazikov.UserApplicationServer.Controller;

import com.dpapazikov.UserApplicationServer.Entity.Person;
import com.dpapazikov.UserApplicationServer.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonRepository personRepo;

    @Autowired
    PersonController(PersonRepository repo)
    {
        this.personRepo = repo;
    }


    //Returns a list of all Persons that exist in the DB
    @GetMapping("/person/get")
    public List<Person> getAllUsers()
    {
    	//personRepo.save(new Person(1, "Asd", "Sad", null));
        return (List<Person>) personRepo.findAll();
    }

    @PostMapping("/person")
    public int addUser(@RequestBody Person person)
    {
        personRepo.save(person);
        return person.getId();
    }

    @PutMapping("/person/{id}")
    public void updateUser(@RequestBody Person person, @PathVariable int id)
    {
        personRepo.findById(id).map(u ->
        {
            u.setFirstName(person.getFirstName());
            u.setLastName(person.getLastName());
            personRepo.save(u);
            return null;
        });
    }

    @DeleteMapping("/person/{id}")
    public void deleteUser(@PathVariable int id)
    {
        personRepo.deleteById(id);
    }


    //Returns the number of Persons in the DB
    @GetMapping("/person/count")
    public long numberOfPersons()
    {
        return personRepo.count();
    }


}
