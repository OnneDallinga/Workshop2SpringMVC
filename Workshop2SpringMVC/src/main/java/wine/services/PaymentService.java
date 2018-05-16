package wine.services;

import wine.domain.Payment;

public interface PaymentService {

    Payment save(Payment payment);

    Payment findPaymentById(Long id);

    Iterable<Payment> findAllPayments();

}
