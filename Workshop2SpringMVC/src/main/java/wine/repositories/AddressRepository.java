package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import wine.domain.Address;
import wine.domain.Customer;

import java.util.Optional;
import java.util.Set;

public interface AddressRepository extends CrudRepository<Address, Long> {

    //Set<Address> findAddressesByCustomer(Customer customer);

    //Optional<Address> findByPostalCode(String postalCode);

}
