package wine.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wine.domain.Invoice;
import wine.domain.Order;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    @Query(value="SELECT * FROM Invoice i WHERE i.settledOn is null", nativeQuery = true)
    Iterable<Invoice> findAllOutstandingInvoices();

}
