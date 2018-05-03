package wine.data;
import org.springframework.data.repository.CrudRepository;

import wine.account.Account;

public interface UserRepository extends CrudRepository<Account, Long> {

	Account findByUsername(String username);

}