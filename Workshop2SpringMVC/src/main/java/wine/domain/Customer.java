package wine.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import wine.utility.BaseEntity;
import wine.domain.Account;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false, exclude={"account"})
public class Customer extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

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

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @Column(nullable = false)
    private List<Address> addressesOfCustomer;

    @OneToMany(mappedBy = "customer",
                  fetch = FetchType.LAZY)
     @Fetch(value = FetchMode.SUBSELECT)
     @Column(nullable = false)
    private List<Order> ordersOfCustomer;
    
    public Customer(String firstName, String lastName, String lastNamePreposition, String email, String phoneNumber) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.lastNamePreposition = lastNamePreposition;
    	this.email = email;
    	this.phoneNumber = phoneNumber;
    }
    
    public void setAccount (Account account) {
    	this.account = account;
    }
    
    public void setId (Long id) {
    	this.id = id;
    }
}
