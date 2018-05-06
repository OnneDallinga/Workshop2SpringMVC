package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.invoicing.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
