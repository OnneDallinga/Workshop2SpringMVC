package wine.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wine.domain.Product;
import wine.domain.Wine;
import wine.repositories.ProductRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    public static final Long WINE_ID = 1L;

    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
    }

    // Testing via Wine class only as its currently the only implementation of the abstract Product superclass

    @Test
    public void saveProductTest() {
        Product wine = new Wine();

        when(productRepository.save(any())).thenReturn(wine);

        Product wineSaved = productService.save(wine);
        assertNotNull(wineSaved);
        verify(productRepository,times(1)).save(any());
    }

    @Test
    public void getProductByIdTest() {
        Product wine = new Wine();
        wine.setId(WINE_ID);
        Optional<Product> wineOptional = Optional.of(wine);

        when(productRepository.findById(anyLong())).thenReturn(wineOptional);

        Product wineRetrieved = productService.findProductById(WINE_ID);
        assertNotNull(wineRetrieved);
        verify(productRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getAllProductsTest() {
        HashSet<Product> productsData = new HashSet<>();
        productsData.add(new Wine());

        when(productService.findAllProducts()).thenReturn(productsData);

        Set<Product> products = (Set<Product>)productService.findAllProducts();
        assertEquals(products.size(), 1);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void deleteProductTest() {
        Long idToDelete = Long.valueOf(WINE_ID);
        productService.deleteById(idToDelete);

        // method is void so no when clause needed

        verify(productRepository,times(1)).deleteById(idToDelete);
    }
}