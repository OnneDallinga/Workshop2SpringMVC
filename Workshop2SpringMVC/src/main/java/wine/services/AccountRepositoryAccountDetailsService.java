package wine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.
        UserDetailsService;
import org.springframework.security.core.userdetails.
        UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import wine.domain.Account;
import wine.repositories.AccountRepository;

@Service
@Primary // necessary to have SecurityConfig look here instead of Spring-given inMemoryUserDetails
public class AccountRepositoryAccountDetailsService
        implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepo;

    @Override
    @Transactional(readOnly = true) // making sure transaction is of read-only type
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