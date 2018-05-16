package wine.services;

import wine.domain.Invoice;

public interface InvoiceService {

    Invoice save(Invoice invoice);

    Invoice findInvoiceById(Long id);

    Iterable<Invoice> findAllInvoices();

    Iterable<Invoice> findAllOutstandingInvoices();

    // No deletion functionality offered

}
