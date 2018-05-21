package wine.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import wine.domain.Account;
import wine.repositories.AccountRepository;
import wine.repositories.AddressRepository;
import wine.repositories.CustomerRepository;
import wine.repositories.WineRepository;

@Slf4j
@Component
public class DatabaseClearer implements ApplicationListener<ContextClosedEvent> {

    private final WineRepository wineRepo;
    private final AccountRepository accountRepo;
    private final CustomerRepository customerRepo;
    private final AddressRepository addressRepo;

    public DatabaseClearer(WineRepository wineRepo,
                           AccountRepository accountRepo,
                           CustomerRepository customerRepo,
                           AddressRepository addressRepo) {
        this.wineRepo = wineRepo;
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
        this.addressRepo = addressRepo;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        wineRepo.deleteAll();
        accountRepo.deleteAll();
        customerRepo.deleteAll();
        addressRepo.deleteAll();
        log.debug("Unloaded all bootstrapped customer data.");
    }
}
