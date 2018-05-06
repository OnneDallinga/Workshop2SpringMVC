package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.address.Address;
import wine.domain.customer.Customer;

import java.util.Set;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Set<Address> findAddressesByCustomer(Customer customer);

    Address findByPostalCode(String postalCode);

}
