package wine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Wine;
import wine.repositories.WineRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class WineServiceImpl implements WineService {

    private final WineRepository wineRepo;

    public WineServiceImpl(WineRepository wineRepo) {
        this.wineRepo = wineRepo;
    }

    @Override
    public Wine save(Wine detachedWine) {
        Wine savedProduct = wineRepo.save(detachedWine);
        log.debug("Saved product with id: " + savedProduct.getId());
        return savedProduct;
    }

    @Override
    @Transactional(readOnly = true)
    public Wine findWineById(Long id) {
        Optional<Wine> productOptional = wineRepo.findById(id);
        if(!productOptional.isPresent()) {
            throw new RuntimeException("No wine found with id: " + id);
        }
        return productOptional.get();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Wine> findAllWines() {
        return wineRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Wine> findAllWinesOutOfStock() {
        return findAllWinesOutOfStock();
    }

    @Override
    public void deleteById(Long idToDelete) {
        wineRepo.deleteById(idToDelete);
        log.debug("Deleted wine with id: " + idToDelete);
    }
}
