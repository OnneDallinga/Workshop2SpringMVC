package wine.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.utility.BaseEntity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Invoice extends BaseEntity<Long> {

    @OneToOne
    private Order order;

    @OneToOne
    @JoinColumn(name = "paymentID",
				referencedColumnName = "id")
    private Payment payment;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date settledOn;

    private boolean isVoided;

}
