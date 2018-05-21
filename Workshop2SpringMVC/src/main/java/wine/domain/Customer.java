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

    private String firstName;
    private String lastName;
    private String lastNamePreposition;
    private String email;
    private String phoneNumber;
    

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Address> addressesOfCustomer;

    @OneToMany(mappedBy = "customer",
                  fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Order> ordersOfCustomer;
    
    public Customer(String firstName, String lastName, String lastNamePreposition, String email, String phoneNumber) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.lastNamePreposition = lastNamePreposition;
    	this.email = email;
    	this.phoneNumber = phoneNumber;
    }
    
    public Customer() {
    	
    }
    
    public void setAccount (Account account) {
    	this.account = account;
    }
    
    public void setId (Long id) {
    	this.id = id;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public String getLastNamePreposition() {
    	return lastNamePreposition;
    }
    
    public void setLastNamePreposition(String lastNamePreposition) {
    	this.lastNamePreposition = lastNamePreposition;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getPhoneNumber() {
    	return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        String lastNamePrep = "";
        if(getLastNamePreposition() != null) {
            lastNamePrep = getLastNamePreposition();
        }
        String fullName = lastNamePrep + " " + getLastName() + ", " + getFirstName();
        return fullName;
    }
}
