package wine.domain.invoicing;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.domain.order.Order;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(exclude={"id"})
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    //@OneToOne
    //private Order order;

    //@OneToOne
    //private Payment payment;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdOn;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date settledOn;

}
