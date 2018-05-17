package wine.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import wine.domain.Wine;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIT {

    // Doesn't pass yet due to create-drop Hibernate

    @Autowired
    WineRepository wineRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findById() {
        Optional<Wine> wineOptional = wineRepository.findById(1L);

        assertEquals(Long.valueOf(1L), wineOptional.get().getId());
    }
}