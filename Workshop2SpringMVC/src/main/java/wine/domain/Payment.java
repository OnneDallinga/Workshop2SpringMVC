package wine.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import wine.utility.BaseEntity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(exclude={"id"})
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Payment extends BaseEntity<Long> {

    enum PaymentMethod {
        IDEAL,
        BANKTRANSFER,
        PAYPAL,
        CREDITCARD
    }

    @OneToOne
    private Invoice invoice;

    @NotNull
    private PaymentMethod paymentMethod;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;

}
