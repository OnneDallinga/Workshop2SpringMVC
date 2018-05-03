package product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull
    private String name;

    @Positive
    @Pattern(regexp="^\\d{0,4}(\\.\\d{2})?$",
             message="Please follow the following format: \"13.37\", \"8.00\".")
    private BigDecimal price;

    @PositiveOrZero
    private int stockQuantity;

    // Suboptimal inplementation of a year range as users can enter future production years.
    @Pattern(regexp="^(19[5-9]\\d|20[0-4]\\d|2020)$",
             message="Accepted year range is 1950 - 2020.")
    private int producedYear;

    @Pattern(regexp="^[a-zA-Z](\\\\s?[a-zA-Z]){4,30}$",
             message="The country name has to be between 4 - 30 letters long.")
    private String country;

    private String grapeVariety;

    @Pattern(regexp="^\\d{0,2}(?:\\.\\d)?$",
             message="Please follow the following format: \"7.2\", \"14.0\".")
    private double alcoholPercentage;

}
