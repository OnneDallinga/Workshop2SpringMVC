package wine.invoicing;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import wine.invoicing.Invoice;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Payment {

    enum PaymentMethod {
        IDEAL,
        BANKTRANSFER,
        PAYPAL,
        CREDITCARD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Invoice invoice;

    private PaymentMethod paymentMethod;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date paymentDateTime;

}
