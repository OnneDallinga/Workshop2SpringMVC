package wine.services;

import wine.domain.Address;

public interface AddressService {

    Address save(Address address);

    Address findAddressById(Long id);

    Iterable<Address> findAllAddresses();

    Address findAddressByPostalCode(String postalCode);

    void deleteById(Long id);

}
