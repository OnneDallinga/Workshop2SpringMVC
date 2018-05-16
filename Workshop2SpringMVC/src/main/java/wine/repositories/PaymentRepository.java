package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import wine.domain.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
