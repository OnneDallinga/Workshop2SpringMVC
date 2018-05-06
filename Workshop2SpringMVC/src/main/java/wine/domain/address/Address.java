package wine.domain.address;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.domain.BaseEntity;
import wine.domain.customer.Customer;

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

    /*@ManyToOne(optional = false)
	@JoinColumn(name = "id",
				nullable = false)
    private Customer customer;*/

    private String street;

    @Positive
    private int houseNumber;

    private String houseNumberAddition;

    @Pattern(regexp="^[0-9]{4}\\\\s*[a-zA-Z]{2}$",
             message="Strictly following format is accepted: 1991AA. Please leave out spaces.")
    private String postalCode;

    private String city;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    public AddressType addressType;

}
