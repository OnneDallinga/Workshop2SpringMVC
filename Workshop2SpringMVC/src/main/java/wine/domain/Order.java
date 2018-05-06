package wine.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.utility.BaseEntity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
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
