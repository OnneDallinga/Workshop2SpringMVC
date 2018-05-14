package wine.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import wine.domain.Product;
import wine.domain.Wine;
import wine.services.ProductService;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ProductControllerTest {

    @Mock
    ProductService productService;

    ProductController productController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productController = new ProductController(productService);
    }

    @Test
    public void getProductsPageTest() {
    }

    @Test
    public void getProductByIdTest() throws Exception {
        Product wine = new Wine();
        wine.setId(1L);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

        when(productService.getProductById(anyLong())).thenReturn(wine);

        mockMvc.perform(get("/products/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("products/show"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    public void getProductByNameTest() throws Exception {

    }
}