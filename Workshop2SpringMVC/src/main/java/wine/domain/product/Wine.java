package wine.domain.product;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Wine extends Product {

    /** The country and grape variety properties bear no annotations/validation due to having
     *  restricted inputs in the web application via e.g. dropdown selection. This aids with
     *  data integrity and controlling valid user input. */

    enum WineClassification {
        RED,
        WHITE,
        ROSE,
        SPARKLING,
        DESSERT,
        FORTIFIED
    }

    private WineClassification wineClassification;

    // NOTE: Suboptimal inplementation of a year range as users can enter future production years
    @NotNull
    private int year;

    @Positive
    private int contentInMl;

    private String countryOfOrigin;

    @Pattern(regexp="^(?:\\w|['-]\\w)+[a-zA-Z](\\\\s?[a-zA-Z]){5,25}$",
            message="Region name has to be between 5 - 25 letters long. Special characters allowed: \"-\" and \"'\".")
    private String region;

    private String grapeVariety;

    @Pattern(regexp="^\\d{0,2}(?:\\.\\d)?$",
             message="Please follow the following format: \"7.2\", \"14.0\".")
    private double alcoholPercentage;

}