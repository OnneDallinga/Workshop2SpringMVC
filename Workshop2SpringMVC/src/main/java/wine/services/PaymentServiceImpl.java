package wine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Payment;
import wine.repositories.PaymentRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepo;

    public PaymentServiceImpl(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public Payment save(Payment detachedPayment) {
        Payment savedPayment = paymentRepo.save(detachedPayment);
        log.debug("Saved payment with id: " + savedPayment.getId());
        return savedPayment;
    }

    @Override
    public Payment findPaymentById(Long id) {
        Optional<Payment> paymentOptional = paymentRepo.findById(id);
        if(!paymentOptional.isPresent()) {
            throw new RuntimeException("No payment found with id " + id);
        }
        return paymentOptional.get();
    }

    @Override
    public Iterable<Payment> findAllPayments() {
        return paymentRepo.findAll();
    }
}
