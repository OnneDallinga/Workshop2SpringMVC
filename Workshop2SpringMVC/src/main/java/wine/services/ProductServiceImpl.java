package wine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wine.domain.Product;
import wine.repositories.ProductRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(!productOptional.isPresent()) {
            throw new RuntimeException("No product found with id: " + id);
        }
        return productOptional.get();
    }

    @Override
    public Product getProductByName(String name) {
        Optional<Product> productOptional = productRepository.findByName(name);
        if(!productOptional.isPresent()) {
            throw new RuntimeException("No product found with name: " + name);
        }
        return productOptional.get();
    }

    @Override
    public Set<Product> getAllProducts() {
        Set<Product> productSet = new HashSet<>();
        productRepository.findAll().iterator().forEachRemaining(productSet::add);
        return productSet;
    }
}
