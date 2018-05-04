package wine.address;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@Entity
@EqualsAndHashCode(of={"postalCode","houseNumber","customer"})
public class Address {

    public enum AddressType {
        BILLING,
        DELIVERY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@NotNull
    private Customer customer;*/

    private String street;

    @Positive
    private int houseNumber;

    private String houseNumberAddition;

    @Pattern(regexp="^[0-9]{4}\\\\s*[a-zA-Z]{2}$",
             message="Strictly following format is accepted: 1991AA. Please leave out spaces.")
    private String postalCode;

    private String city;

    public AddressType addressType;

}
