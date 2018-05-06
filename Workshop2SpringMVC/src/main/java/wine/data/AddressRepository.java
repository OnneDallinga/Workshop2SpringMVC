package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.address.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
