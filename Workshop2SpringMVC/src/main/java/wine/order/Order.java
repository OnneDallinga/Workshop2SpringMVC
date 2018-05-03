package wine.order;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import wine.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(exclude={"id","itemsInOrder"})
public class Order {

    @Id
    private Long id;

    @NotNull
    private Customer customer;

    @NotNull
    private List<OrderLineItem> itemsInOrder;

    private BigDecimal orderPriceTotal;
    private int orderItemsTotal;
    private boolean shipped;
    private boolean completed;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date placedOn;
}
