package domain.order;

import domain.customer.Customer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
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
}
