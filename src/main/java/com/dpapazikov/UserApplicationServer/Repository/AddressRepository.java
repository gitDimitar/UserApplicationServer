package com.dpapazikov.UserApplicationServer.Repository;

import com.dpapazikov.UserApplicationServer.Entity.Address;
import com.dpapazikov.UserApplicationServer.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    public Person findPersonById(int id);

}
