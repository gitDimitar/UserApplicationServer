package Repository;

import Entity.Address;
import Entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    public List<Address> findAddressesByUser(Person person);

    public Person findPersonById(int id);

}
