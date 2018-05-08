package wine.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wine.domain.Product;
import wine.domain.Wine;
import wine.repositories.ProductRepository;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    // Passes

    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void getAllProducts() {
        HashSet<Product> productsData = new HashSet<>();
        productsData.add(new Wine());

        when(productService.getAllProducts()).thenReturn(productsData);

        Set<Product> products = productService.getAllProducts();
        assertEquals(products.size(), 1);
        verify(productRepository, times(1)).findAll();
    }
}