package wine.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wine.account.Account;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@EqualsAndHashCode(exclude={"id","account"})
public class Customer {

    @Id
    private long customerId;

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

}
