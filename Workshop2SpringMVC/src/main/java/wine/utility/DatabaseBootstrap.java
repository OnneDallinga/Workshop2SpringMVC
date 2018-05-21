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
        accountRepo.saveAll(getAccounts());
        populateAddresses();
        customerRepo.saveAll(getCustomers());
        log.debug("Loading Bootstrap Data");
    }

    private List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account accountForCustomer1 = new Account("jantjepantje",
                                            passwordEncoder.encode("hoiikbenjantje"));
        accounts.add(accountForCustomer1);

        Account accountForCustomer2 = new Account("bertrandschmertrand",
                                            passwordEncoder.encode("hoiikbenbertrand"));
        accounts.add(accountForCustomer2);
        return accounts;
    }

    private void populateAddresses() {
        Address deliveryAddressForCustomer1 = new Address();
        deliveryAddressForCustomer1.setAddressType(Address.AddressType.DELIVERY);
        deliveryAddressForCustomer1.setPostalCode("1111AA");
        deliveryAddressForCustomer1.setHouseNumber(84);
        deliveryAddressForCustomer1.setStreet("Jengelplein");
        deliveryAddressForCustomer1.setCity("Volendam");
        addressRepo.save(deliveryAddressForCustomer1);

        Address deliveryAddressForCustomer2 = new Address();
        deliveryAddressForCustomer2.setAddressType(Address.AddressType.DELIVERY);
        deliveryAddressForCustomer2.setPostalCode("8888BA");
        deliveryAddressForCustomer2.setHouseNumber(2);
        deliveryAddressForCustomer2.setHouseNumberAddition("A");
        deliveryAddressForCustomer2.setStreet("J.F. Kennedylaan");
        deliveryAddressForCustomer2.setCity("Weesp");
        addressRepo.save(deliveryAddressForCustomer2);

        Address billingAddressForCustomer2 = new Address();
        billingAddressForCustomer2.setAddressType(Address.AddressType.BILLING);
        billingAddressForCustomer2.setPostalCode("2717KL");
        billingAddressForCustomer2.setHouseNumber(14);
        billingAddressForCustomer2.setStreet("Groot Haesebroekseweg");
        billingAddressForCustomer2.setCity("Wassenaar");
        addressRepo.save(billingAddressForCustomer2);

    }

    private List<Customer> getCustomers() {

        List<Address> addressList = (List<Address>)addressRepo.findAll();
        List<Address> customer1Addresses = new ArrayList<>();
        customer1Addresses.add(0,addressList.get(0));
        List<Address> customer2Addresses = new ArrayList<>();
        customer2Addresses.add(0, addressList.get(1));
        customer2Addresses.add(1, addressList.get(2));

        List<Customer> customers = new ArrayList<>();
        
        Customer customer1 = new Customer();
        customer1.setAccount(accountRepo.findByUsername("jantjepantje"));
        customer1.setFirstName("Jantje");
        customer1.setLastName("Smit");
        customer1.setEmail("jantje@gmail.com");
        customer1.setPhoneNumber("0677332211");
        customer1.setAddressesOfCustomer(customer1Addresses);
        customers.add(0, customer1);

        Customer customer2 = new Customer();
        customer2.setAccount(accountRepo.findByUsername("bertrandschmertrand"));
        customer2.setFirstName("Bertrand");
        customer2.setLastName("Dolder-Henegouwen");
        customer2.setLastNamePreposition("van den");
        customer2.setEmail("bertrandowntalles@hotmail.com");
        customer2.setPhoneNumber("02044556611");
        customer1.setAddressesOfCustomer(customer2Addresses);
        customers.add(1, customer2);

        return customers;
    }

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

