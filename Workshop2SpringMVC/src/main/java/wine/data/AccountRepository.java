package wine.data;
import org.springframework.data.repository.CrudRepository;

import wine.account.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findByUsername(String username);

}