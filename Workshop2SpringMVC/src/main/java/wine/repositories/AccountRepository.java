package wine.repositories;
import org.springframework.data.repository.CrudRepository;

import wine.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findByUsername(String username);

}