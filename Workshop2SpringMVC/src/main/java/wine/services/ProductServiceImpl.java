package wine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Product;
import wine.repositories.ProductRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product save(Product detachedProduct) {
        Product savedProduct = productRepo.save(detachedProduct);
        log.debug("Saved product with id: " + savedProduct.getId());
        return savedProduct;
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if(!productOptional.isPresent()) {
            throw new RuntimeException("No product found with id: " + id);
        }
        return productOptional.get();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAllProductsOutOfStock() {
        return productRepo.findAllProductsOutOfStock();
    }

    @Override
    public void deleteById(Long idToDelete) {
        productRepo.deleteById(idToDelete);
        log.debug("Deleted product with id: " + idToDelete);
    }
}
