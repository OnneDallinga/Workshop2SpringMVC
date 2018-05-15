package wine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Product;
import wine.repositories.ProductRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product detachedProduct) {
        Product savedProduct = productRepository.save(detachedProduct);
        log.debug("Saved product with id: " + savedProduct.getId());
        return savedProduct;
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(!productOptional.isPresent()) {
            throw new RuntimeException("No product found with id: " + id);
        }
        return productOptional.get();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long idToDelete) {
        productRepository.deleteById(idToDelete);
        log.debug("Deleted product with id: " + idToDelete);
    }
}
