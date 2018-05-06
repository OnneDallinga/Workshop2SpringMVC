package wine.domain.order;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(exclude={"id","itemsInOrder"})
public class Order {

    @Id
    private Long id;

    @NotNull
    private int customerId;

    /*@NotNull
    @OneToMany
    private List<OrderLineItem> itemsInOrder;*/

    private BigDecimal orderPriceTotal;
    private int orderItemsTotal;
    private boolean shipped;
    private boolean completed;

    private Date createdAt;
    
    @PrePersist
    private void createdAt() {
    	this.createdAt = new Date();
    }
}
