package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import wine.domain.Invoice;
import wine.domain.Order;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    //Invoice findByOrder(Order order);
    
}
