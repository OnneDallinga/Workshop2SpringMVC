package wine.services;

import wine.domain.Wine;

public interface WineService {

    Wine save(Wine wine);

    Wine findWineById(Long id);

    Iterable<Wine> findAllWines();

    Iterable<Wine> findAllWinesOutOfStock();

    void deleteById(Long id);

}
