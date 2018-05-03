package wine.invoicing;

import lombok.Data;
import wine.order.Order;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Order order;

    private Payment payment;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdOnDateTime;

}
