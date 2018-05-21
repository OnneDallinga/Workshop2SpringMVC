package wine.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.utility.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@Entity
@EqualsAndHashCode(callSuper=false, of={"postalCode","houseNumber","customer"})
public class Address extends BaseEntity<Long> {

    public enum AddressType {
        BILLING,
        DELIVERY
    }

    private String street;

    private int houseNumber;

    private String houseNumberAddition;

    @Pattern(regexp="^[1-9][0-9]{3}[\\s]?[A-Za-z]{2}$",
             message="Formats accepted: 1111AA, 1111 AA.")
    private String postalCode;

    private String city;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    public AddressType addressType;

}
