package wine.configuration;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import wine.domain.Account;

@Data
public class RegistrationForm {

	@Size(min = 5, message = "Your username must be at least 5 characters long")
	@Pattern(regexp = "[A-Za-z0-9_]+", message = "Your username must be at least 5 characters long and"
			+ "consist only of letters or numbers")
	private String username;

    @Size(min = 8, message = "Your password must be at least 8 characters long.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$", message = "Your password must contain at least one uppercase letter, one lowercase letter,"
            + " one number and one special character.")
	private String password;

	public Account toAccount(PasswordEncoder passwordEncoder) {
		return new Account(username, passwordEncoder.encode(password));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}