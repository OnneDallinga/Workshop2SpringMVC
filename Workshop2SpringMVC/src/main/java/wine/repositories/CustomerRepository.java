package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import wine.domain.Customer;

import java.util.Optional;
import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //Set<Customer> findAllByLastName(String lastName);

    //Optional<Customer> findByEmail(String email);

    //Optional<Customer> findByPhoneNumber(String phoneNumber);

}
