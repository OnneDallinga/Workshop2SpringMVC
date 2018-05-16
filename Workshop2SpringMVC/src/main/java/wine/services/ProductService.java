package wine.services;

import wine.domain.Product;

public interface ProductService {

    Product save(Product product);

    Product findProductById(Long id);

    Iterable<Product> findAllProducts();

    // TODO implement in controller
    Iterable<Product> findAllProductsOutOfStock();

    void deleteById(Long id);

}
