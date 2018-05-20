package wine.repositories;

import org.springframework.data.repository.CrudRepository;

import wine.domain.Authorities;

public interface AuthorityRepository extends CrudRepository<Authorities, Long> {

	Authorities findByUsername(String username);

}