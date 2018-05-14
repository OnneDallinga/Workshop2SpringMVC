package wine.configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import wine.domain.Account;

@Data
public class RegistrationForm {

  private String username;
  private String password;

  public Account toAccount(PasswordEncoder passwordEncoder) {
	  System.out.println(username + password);

    return new Account(
        username, passwordEncoder.encode(password));
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