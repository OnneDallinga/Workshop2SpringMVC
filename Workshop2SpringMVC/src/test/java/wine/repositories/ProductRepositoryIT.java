package wine.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import wine.domain.Product;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIT {

    // Doesn't pass yet due to no proper mapping+db data in place

    @Autowired
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByName() {

        Optional<Product> productOptional = productRepository.findByName("Avec La Poisson");

        assertEquals("Avec La Poisson", productOptional.get().getName());

    }
}