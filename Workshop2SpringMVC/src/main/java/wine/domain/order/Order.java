package wine.domain.order;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper=false, exclude={"itemsInOrder"})
public class Order extends BaseEntity<Long> {

    /* @NotNull
    @ManyToOne(optional = false)
    private Customer customer; */

    /*@NotNull
    @OneToMany(mappedBy = "parentOrder",
			   fetch = FetchType.EAGER,
			   cascade = CascadeType.ALL,
			   orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<OrderLineItem> itemsInOrder;*/

    private BigDecimal orderPriceTotal;
    private int orderItemsTotal;
    private boolean shipped;
    private boolean completed;

}
