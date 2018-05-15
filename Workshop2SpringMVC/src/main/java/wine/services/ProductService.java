package wine.services;

import wine.domain.Product;

public interface ProductService {

    // Create & Update

    Product save(Product product);

    // Read

    Product findProductById(Long id);

    Iterable<Product> findAllProducts();

    // Delete

    void deleteById(Long id);

}
