package wine.domain.order;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class OrderLineItem extends BaseEntity<Long> {

    /*@NotNull
    @ManyToOne(optional = false)
	@JoinColumn(name = "orderID",
				referencedColumnName = "id")
	private Order parentOrder;

    @NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "productID",
				referencedColumnName = "id")
	private Product product;*/

    @Positive
    private int productQuantity;

}
