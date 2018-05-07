package wine.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.
                                              UserDetailsService;
import org.springframework.security.core.userdetails.
                                       UsernameNotFoundException;
import org.springframework.stereotype.Service;

import wine.domain.Account;
import wine.repositories.AccountRepository;

@Service
public class AccountRepositoryAccountDetailsService
        implements UserDetailsService {

  private AccountRepository accountRepo;

  @Autowired
  public AccountRepositoryAccountDetailsService(AccountRepository accountRepo) {
    this.accountRepo = accountRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    Account account = accountRepo.findByUsername(username);
    if (account != null) {
      return account;
    }
    throw new UsernameNotFoundException(
                    "User '" + username + "' not found");
  }

}