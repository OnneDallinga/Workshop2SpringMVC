package wine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Invoice;
import wine.repositories.InvoiceRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepo;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    @Override
    public Invoice save(Invoice detachedInvoice) {
        Invoice savedInvoice = invoiceRepo.save(detachedInvoice);
        log.debug("Saved invoice with id: " + savedInvoice.getId());
        return savedInvoice;
    }

    @Override
    @Transactional(readOnly = true)
    public Invoice findInvoiceById(Long id) {
        Optional<Invoice> invoiceOptional = invoiceRepo.findById(id);
        if(!invoiceOptional.isPresent()) {
            throw new RuntimeException("No invoice found with id: " + id);
        }
        return invoiceOptional.get();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Invoice> findAllInvoices() {
        return invoiceRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Invoice> findAllOutstandingInvoices() {
        return invoiceRepo.findAllOutstandingInvoices();
    }
}
