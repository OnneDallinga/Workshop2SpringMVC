package wine.domain.product;

import lombok.Data;
import wine.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product extends BaseEntity<Long> {

    @NotNull
    String name;

    @NotNull
    String description;

    @Positive
    @Pattern(regexp="^\\d{0,4}(\\.\\d{2})?$",
            message="Please follow the following format: \"13.37\", \"8.00\".")
    BigDecimal price;

    @PositiveOrZero
    int stockQuantity;

}
