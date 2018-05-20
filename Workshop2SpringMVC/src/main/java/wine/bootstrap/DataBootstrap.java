package wine.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Wine;
import wine.repositories.WineRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DataBootstrap.class);
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

    private List<Wine> getWines() {
        List<Wine> wines = new ArrayList<>(2);
        
        Wine wine1 = new Wine();
        wine1.setName("Topwijn");
        wine1.setPrice(new BigDecimal("10"));
        wine1.setStockQuantity(5);
        wine1.setDescription("Gewoon lekker spul joh. Kopen kopen kopen!");
        wine1.setWineClassification(Wine.WineClassification.RED);
        wine1.setContentInMl(750);
        wine1.setCountryOfOrigin("Nederland");
        wine1.setRegion("Gelderland");
        wine1.setGrapeVariety("Druif");
        wine1.setYear(2018);
        wine1.setAlcoholPercentage(14.2);
        wines.add(wine1);
        
        Wine wine2 = new Wine();
        wine2.setName("Meukwijn");
        wine2.setPrice(new BigDecimal("1"));
        wine2.setStockQuantity(20);
        wine2.setDescription("Gewoon... niet zo lekker spul joh. Ik zou 't niet doen als ik jou was.");
        wine2.setWineClassification(Wine.WineClassification.DESSERT);
        wine2.setContentInMl(1000);
        wine2.setCountryOfOrigin("Spanje");
        wine2.setRegion("Rioja");
        wine2.setGrapeVariety("Syrah");
        wine2.setYear(2011);
        wine2.setAlcoholPercentage(13.8);
        wines.add(wine2);
        
        return wines;
    }
}
