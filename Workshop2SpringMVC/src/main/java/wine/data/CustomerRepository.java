package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.customer.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
