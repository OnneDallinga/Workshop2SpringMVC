package wine.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Account;
import wine.domain.Address;
import wine.domain.Customer;
import wine.domain.Wine;
import wine.repositories.AccountRepository;
import wine.repositories.AddressRepository;
import wine.repositories.CustomerRepository;
import wine.repositories.WineRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class DatabaseBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DatabaseBootstrap.class);
    private final WineRepository wineRepo;
    private final AccountRepository accountRepo;
    private final CustomerRepository customerRepo;
    private final AddressRepository addressRepo;

    public DatabaseBootstrap(WineRepository wineRepo,
                             AccountRepository accountRepo,
                             CustomerRepository customerRepo,
                             AddressRepository addressRepo) {
        this.wineRepo = wineRepo;
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
        this.addressRepo = addressRepo;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        wineRepo.saveAll(getWines());
 /*     accountRepo.saveAll(getAccounts());
        customerRepo.saveAll(getCustomers());
        addressRepo.saveAll(getAddresses(setCustomersForAddresses()));*/
        log.debug("Loading Bootstrap Data");
    }

/*    private List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account accountForCustomer1 = new Account("jantjepantje",
                                            passwordEncoder.encode("hoiikbenjantje"));
        accounts.add(accountForCustomer1);

        Account accountForCustomer2 = new Account("bertrandschmertrand",
                                            passwordEncoder.encode("hoiikbenbertrand"));
        accounts.add(accountForCustomer2);
        return accounts;
    }

    private List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setAccount(accountRepo.findByUsername("jantjepantje"));
        customer1.setFirstName("Jantje");
        customer1.setLastName("Smit");
        customer1.setEmail("jantje@gmail.com");
        customer1.setPhoneNumber("0677332211");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setAccount(accountRepo.findByUsername("bertrandschmertrand"));
        customer2.setFirstName("Bertrand");
        customer2.setLastName("Dolder-Henegouwen");
        customer2.setLastNamePreposition("van den");
        customer2.setEmail("bertrandowntalles@hotmail.com");
        customer2.setPhoneNumber("02044556611");
        customers.add(customer2);

        return customers;
    }

    private List<Customer> setCustomersForAddresses() {
        List<Customer> customersForAddresses = new ArrayList<>();
        Optional<Customer> customer1 = customerRepo.findById(1L);
        Optional<Customer> customer2 = customerRepo.findById(2L);
        customersForAddresses.add(customer1.get());
        customersForAddresses.add(customer2.get());
        return customersForAddresses;
    }

    private List<Address> getAddresses(List<Customer> customers) {
        List<Address> addresses = new ArrayList<>();
        Address deliveryAddressForCustomer1 = new Address();
        deliveryAddressForCustomer1.setCustomer(customers.get(0));
        deliveryAddressForCustomer1.setAddressType(Address.AddressType.DELIVERY);
        deliveryAddressForCustomer1.setPostalCode("1111AA");
        deliveryAddressForCustomer1.setHouseNumber(84);
        deliveryAddressForCustomer1.setStreet("Jengelplein");
        deliveryAddressForCustomer1.setCity("Volendam");
        addresses.add(deliveryAddressForCustomer1);

        Address deliveryAddressForCustomer2 = new Address();
        deliveryAddressForCustomer2.setCustomer(customers.get(1));
        deliveryAddressForCustomer1.setAddressType(Address.AddressType.DELIVERY);
        deliveryAddressForCustomer1.setPostalCode("8888ZA");
        deliveryAddressForCustomer1.setHouseNumber(2);
        deliveryAddressForCustomer1.setStreet("J.F. Kennedylaan");
        deliveryAddressForCustomer1.setCity("Weesp");
        addresses.add(deliveryAddressForCustomer2);

        Address billingAddressForCustomer2 = new Address();
        deliveryAddressForCustomer2.setCustomer(customers.get(1));
        deliveryAddressForCustomer1.setAddressType(Address.AddressType.BILLING);
        deliveryAddressForCustomer1.setPostalCode("2717KL");
        deliveryAddressForCustomer1.setHouseNumber(2);
        deliveryAddressForCustomer1.setStreet("Groot Haesebroekseweg");
        deliveryAddressForCustomer1.setCity("Wassenaar");
        addresses.add(billingAddressForCustomer2);

        return addresses;
    }*/

    private List<Wine> getWines() {
        List<Wine> wines = new ArrayList<>();

        Wine wine1 = new Wine();
        wine1.setCreationDate();
        wine1.setName("Campo Viejo Reserva");
        wine1.setPrice(new BigDecimal("7.49"));
        wine1.setStockQuantity(47);
        wine1.setDescription("Gewoon lekker spul joh. Kopen kopen kopen!");
        wine1.setWineClassification(Wine.WineClassification.RED);
        wine1.setContentInMl(750);
        wine1.setCountryOfOrigin("Spain");
        wine1.setRegion("Rioja");
        wine1.setGrapeVariety("Tempranillo");
        wine1.setYear(2015);
        wine1.setAlcoholPercentage(13.5);
        wines.add(wine1);

        Wine wine2 = new Wine();
        wine1.setCreationDate();
        wine2.setName("Inycon Estate Viognier");
        wine2.setPrice(new BigDecimal("10.59"));
        wine2.setStockQuantity(28);
        wine2.setDescription("Gewoon lekker spul joh. Kopen kopen kopen!");
        wine2.setWineClassification(Wine.WineClassification.WHITE);
        wine2.setContentInMl(750);
        wine2.setCountryOfOrigin("Italy");
        wine2.setRegion("Sicily");
        wine2.setGrapeVariety("Viognier");
        wine2.setYear(2016);
        wine2.setAlcoholPercentage(13);
        wines.add(wine2);

        Wine wine3 = new Wine();
        wine1.setCreationDate();
        wine3.setName("Arrogant Frog Rosé");
        wine3.setPrice(new BigDecimal("7.19"));
        wine3.setStockQuantity(9);
        wine2.setDescription("Gewoon lekker spul joh. Kopen kopen kopen!");
        wine3.setWineClassification(Wine.WineClassification.ROSE);
        wine3.setContentInMl(1000);
        wine3.setCountryOfOrigin("France");
        wine3.setRegion("Languedoc-Rousillon");
        wine3.setGrapeVariety("Syrah");
        wine3.setYear(2015);
        wine3.setAlcoholPercentage(12.5);
        wines.add(wine3);

        Wine wine4 = new Wine();
        wine1.setCreationDate();
        wine4.setName("Dom Perignon Magnum Champagne");
        wine4.setPrice(new BigDecimal("844"));
        wine4.setStockQuantity(1);
        wine4.setDescription("Beetje erg duur hè? Ik zou 't niet doen als ik jou was.");
        wine4.setWineClassification(Wine.WineClassification.SPARKLING);
        wine4.setContentInMl(1500);
        wine4.setCountryOfOrigin("France");
        wine4.setRegion("Champagne");
        wine4.setGrapeVariety("Chardonnay");
        wine4.setYear(2003);
        wine4.setAlcoholPercentage(12.5);
        wines.add(wine4);

        return wines;
    }
}

