package wine.customer;

import lombok.Data;
import wine.account.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @NotNull
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
