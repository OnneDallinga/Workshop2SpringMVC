package wine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Address;
import wine.repositories.AddressRepository;
import wine.repositories.CustomerRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepo;

    public AddressServiceImpl(AddressRepository addressRepo, CustomerRepository customerRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address save(Address detachedAddress) {
        Address savedAddress = addressRepo.save(detachedAddress);
        log.debug("Saved address with id: " + savedAddress.getId());
        return savedAddress;
    }

    @Override
    @Transactional(readOnly = true)
    public Address findAddressById(Long id) {
        Optional<Address> addressOptional = addressRepo.findById(id);
        if(!addressOptional.isPresent()) {
            throw new RuntimeException("No address found with id: " + id);
        }
        return addressOptional.get();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Address> findAllAddresses() {
        return addressRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Address> findAllAddressesByCustomerId(Long customerId) {
        return addressRepo.findAddressesByCustomerId(customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public Address findAddressByPostalCode(String postalCode) {
        Optional<Address> addressOptional = addressRepo.findAddressByPostalCode(postalCode);
        if(!addressOptional.isPresent()) {
            throw new RuntimeException("No address found with postal code: " + postalCode);
        }
        return addressOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        addressRepo.deleteById(idToDelete);
        log.debug("Deleted address with id: " + idToDelete);
    }
}
