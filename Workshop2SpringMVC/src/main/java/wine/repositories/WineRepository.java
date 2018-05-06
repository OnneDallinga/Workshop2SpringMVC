package wine.repositories;

import wine.domain.Wine;

import java.util.Set;

public interface WineRepository {

    Set<Wine> findAllByWineClassification(Wine.WineClassification wineClassification);

    Set<Wine> findByYear(int year);

    Set<Wine> findByCountry(String country);

    Set<Wine> findByRegion(String region);

    Set<Wine> findByGrapeVariety(String grapeVariety);

}
