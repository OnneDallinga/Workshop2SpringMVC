package wine.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Wine;
import wine.repositories.WineRepository;

@Slf4j
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final WineRepository wineRepo;

    public DataBootstrap(WineRepository wineRepo) {
        this.wineRepo = wineRepo;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        wineRepo.saveAll(getWines());
        log.debug("Loading Bootstrap Data for wines");
    }
}
