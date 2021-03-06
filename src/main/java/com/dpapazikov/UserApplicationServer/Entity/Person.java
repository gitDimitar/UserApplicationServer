package com.dpapazikov.UserApplicationServer.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="person_id", nullable = false)
    List<Address> addressList;

    public Person()
    {
        this.addressList = new ArrayList<>();
    }

    public Person(int id)
    {
        this.id = id;
        this.addressList = new ArrayList<>();
    }

    @JsonCreator
    public Person(int id, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, List<Address> addressList)
    {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressList =  new ArrayList<>();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public List<Address> getAddressList()
    {
        return addressList;
    }

    public void setAddressList(List<Address> addressList)
    {
        this.addressList = addressList;
    }

    public void addAddressToList(Address address)
    {
        this.addressList.add(address);
    }

}
