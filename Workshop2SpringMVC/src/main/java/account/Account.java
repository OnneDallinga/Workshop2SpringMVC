package account;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Account {
	
	public enum OwnerType {
		ADMIN,
		EMPLOYEE,
		CUSTOMER
	}
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	  
	  @NotNull
	  @Size(min=5, message="Your username must be at least 5 characters long")
	  @Pattern(regexp="[A-Za-z0-9_]+", message="Your username must be at least 5 characters long and"
	  		+ "consist only of letters or numbers")
	  private String username;

	  @NotNull
	  @Size(min=8, message ="Your password must be at least 8 characters long.")
	  @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$",
			  message="Your password must contain at least one uppercase letter, one lowercase letter,"
			  		+ " one number and one special character.")
	  private String password;
	  
	  private String encryptedPassword;
	  
	  private String salt;
	  
	  private Date createdAt;
	  
	  private OwnerType ownerType;
	  
}
