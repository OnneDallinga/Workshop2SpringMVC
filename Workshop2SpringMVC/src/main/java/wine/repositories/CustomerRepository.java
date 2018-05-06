package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import wine.domain.Customer;

import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Set<Customer> findAllByLastName(String lastName);

    Customer findByEmail(String email);

    Customer findByPhoneNumber(String phoneNumber);


}
