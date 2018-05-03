package wine.order;

import lombok.Data;
import wine.product.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Order parentOrder;

    @NotNull
    private Product product;

    @Positive
    private int productQuantity;

}
