package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.account.Account;
import wine.domain.customer.Customer;

import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Set<Customer> findAllByLastName(String lastName);

    Customer findByEmail(String email);

    Customer findByPhoneNumber(String phoneNumber);


}
