package wine.configuration;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import wine.domain.Customer;

@Data
public class CustomerForm {

	@Pattern(regexp = "[a-zA-Z]+", message = "Your first name cannot contain any numbers or special characters.")
	private String firstName;

	@Pattern(regexp = "[a-zA-Z]+", message = "Your last name cannot contain any numbers or special characters.")
	private String lastName;

	@Pattern(regexp = "(^$|^[a-zA-Z]+)", message = "Your preposition cannot contain any numbers or special characters")
	private String lastNamePreposition;

	@Email
	private String email;

	@Pattern(regexp = "[0-9]{10}", message = "Entry needs to be exactly 10 numbers (e.g. 0611223344). No spaces, dashes etc.")
	private String phoneNumber;

	public Customer createCustomer() {
		return new Customer(firstName, lastName, lastNamePreposition, email, phoneNumber);
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
	

}