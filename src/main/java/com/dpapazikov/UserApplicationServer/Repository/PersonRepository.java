package com.dpapazikov.UserApplicationServer.Repository;

import com.dpapazikov.UserApplicationServer.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
