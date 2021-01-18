package Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy="person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
        this.addressList =  new ArrayList<>(addressList);
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
