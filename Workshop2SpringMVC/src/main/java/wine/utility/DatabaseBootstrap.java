package wine.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Wine;
import wine.repositories.WineRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DatabaseBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final WineRepository wineRepo;

    public DatabaseBootstrap(WineRepository wineRepo) {
        this.wineRepo = wineRepo;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        wineRepo.saveAll(getWines());
        log.debug("Loading Bootstrap Data for Wines");
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

        Wine wine3 = new Wine();
        wine3.setName("Meukwijn");
        wine3.setPrice(new BigDecimal("1"));
        wine3.setStockQuantity(30);
        wine3.setDescription("Gewoon... niet zo lekker spul joh. Ik zou 't niet doen als ik jou was.");
        wine3.setWineClassification(Wine.WineClassification.DESSERT);
        wine3.setContentInMl(1000);
        wine3.setCountryOfOrigin("Spanje");
        wine3.setRegion("Rioja");
        wine3.setGrapeVariety("Syrah");
        wine3.setYear(3011);
        wine3.setAlcoholPercentage(13.8);
        wines.add(wine3);

        Wine wine4 = new Wine();
        wine4.setName("Meukwijn");
        wine4.setPrice(new BigDecimal("1"));
        wine4.setStockQuantity(40);
        wine4.setDescription("Gewoon... niet zo lekker spul joh. Ik zou 't niet doen als ik jou was.");
        wine4.setWineClassification(Wine.WineClassification.DESSERT);
        wine4.setContentInMl(1000);
        wine4.setCountryOfOrigin("Spanje");
        wine4.setRegion("Rioja");
        wine4.setGrapeVariety("Syrah");
        wine4.setYear(4011);
        wine4.setAlcoholPercentage(14.8);
        wines.add(wine4);
        
        return wines;
    }
}

