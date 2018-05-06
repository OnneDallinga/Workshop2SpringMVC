package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.invoicing.Invoice;
import wine.domain.order.Order;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    Invoice findByOrder(Order order);
    
}
