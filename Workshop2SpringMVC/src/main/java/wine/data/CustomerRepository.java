package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.customer.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
