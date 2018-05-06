package wine.domain.order;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Data
@Entity
@EqualsAndHashCode(exclude={"id"})
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /*@NotNull
    private Order parentOrder;

    @NotNull
    private Product product;*/

    @Positive
    private int productQuantity;

}
