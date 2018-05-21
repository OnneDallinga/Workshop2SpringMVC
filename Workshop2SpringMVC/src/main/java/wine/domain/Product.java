package wine.domain;

import lombok.Data;
import wine.utility.BaseEntity;

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

    @Lob
    String description;

    @Positive
    BigDecimal price;

    @PositiveOrZero
    int stockQuantity;

    @Lob
    Byte[] image;

}
