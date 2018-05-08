package wine.configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import wine.domain.Account;

@Data
public class RegistrationForm {

  private String username;
  private String password;

  public Account toAccount(PasswordEncoder passwordEncoder) {

    return new Account(
        username, passwordEncoder.encode(password));
  }
}