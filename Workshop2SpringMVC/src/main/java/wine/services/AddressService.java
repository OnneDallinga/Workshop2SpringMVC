package wine.services;

import wine.domain.Address;

public interface AddressService {

    Address save(Address address);

    Address findAddressById(Long id);

    Iterable<Address> findAllAddresses();

    Iterable<Address> findAllAddressesByCustomerId(Long customerId);

    Address findAddressByPostalCode(String postalCode);

    void deleteById(Long id);

}
