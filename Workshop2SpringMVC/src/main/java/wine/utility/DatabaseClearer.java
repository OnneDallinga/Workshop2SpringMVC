package wine.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import wine.repositories.WineRepository;

@Slf4j
@Component
public class DatabaseClearer implements ApplicationListener<ContextClosedEvent> {

    private final WineRepository wineRepo;

    public DatabaseClearer(WineRepository wineRepo) {
        this.wineRepo = wineRepo;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        wineRepo.deleteAll();
        log.debug("Unloaded all bootstrapped wine data.");
    }
}
