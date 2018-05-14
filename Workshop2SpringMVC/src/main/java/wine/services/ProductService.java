package wine.services;

import wine.domain.Product;

import java.util.Optional;
import java.util.Set;

public interface ProductService {

    Product getProductById(Long id);

    Product getProductByName(String name);

    Set<Product> getAllProducts();

}
