package wine.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wine.domain.Address;
import wine.domain.Customer;

import java.util.Optional;
import java.util.Set;

public interface AddressRepository extends CrudRepository<Address, Long> {

    @Query("FROM Address a JOIN a.customer c WHERE c.id=customerId")
    Iterable<Address> findAddressesByCustomerId(@Param("customerId") Long customerId);

    @Query("FROM Address a WHERE a.postalCode=postalCode")
    Optional<Address> findAddressByPostalCode(@Param("postalCode") String postalCode);

}
