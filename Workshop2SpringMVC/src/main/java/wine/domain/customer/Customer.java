package wine.domain.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import wine.domain.BaseEntity;
import wine.domain.account.Account;
import wine.domain.address.Address;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false, exclude={"account"})
public class Customer extends BaseEntity<Long> {

	@PrimaryKeyJoinColumn 
	@OneToOne(
			fetch = FetchType.LAZY,
			optional = false)
    private Account account;

    @Pattern(regexp="[a-zA-Z]",
             message="Your first name cannot contain any numbers or special characters.")
    private String firstName;

    @Pattern(regexp="[a-zA-Z]",
            message="Your first name cannot contain any numbers or special characters.")
    private String lastName;

    @Pattern(regexp="[a-zA-Z]",
            message="Your first name cannot contain any numbers or special characters.")
    private String lastNamePreposition;

    @Email
    private String email;

    @Pattern(regexp="[0-9]{10}",
             message="Entry needs to be exactly 10 numbers (e.g. 0611223344). No spaces, dashes etc.")
    private String phoneNumber;

    /* @OneToMany(mappedBy = "customer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @Column(nullable = false)
    private List<Address> addressesOfCustomer; */

}
