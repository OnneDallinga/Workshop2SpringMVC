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
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
    }

    // Testing via Wine class only as its currently the only implementation of the abstract Product superclass

    // Passes

    @Test
    public void getProductByIdTest() {
        Product wine = new Wine();
        wine.setId(10L);
        Optional<Product> wineOptional = Optional.of(wine);

        when(productRepository.findById(anyLong())).thenReturn(wineOptional);

        Product wineRetrieved = productService.getProductById(10L);
        assertNotNull(wineRetrieved);
        verify(productRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getProductByNameTest() {
        Product wine = new Wine();
        wine.setName("Sacre Bleu");
        Optional<Product> wineOptional = Optional.of(wine);

        when(productRepository.findByName(anyString())).thenReturn(wineOptional);

        Product wineRetrieved = productService.getProductByName(anyString());
        assertNotNull(wineRetrieved);
        verify(productRepository, times(1)).findByName(anyString());
    }

    @Test
    public void getAllProductsTest() {
        HashSet<Product> productsData = new HashSet<>();
        productsData.add(new Wine());

        when(productService.getAllProducts()).thenReturn(productsData);

        Set<Product> products = productService.getAllProducts();
        assertEquals(products.size(), 1);
        verify(productRepository, times(1)).findAll();
    }
}