package com.dpapazikov.UserApplicationServer.Entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String city;
    private String state;
    private String postCode;

    public Address()
    {
    }

    public Address(int id, String street, String city, String state, String postCode)
    {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

}
