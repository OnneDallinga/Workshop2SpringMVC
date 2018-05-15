package wine.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import wine.domain.Product;
import wine.domain.Wine;
import wine.services.ProductService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ProductControllerTest {

    private static final Long WINE_ID = 1l;

    @Mock
    ProductService productService;

    ProductController productController;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productController = new ProductController(productService);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void getProductformTest() throws Exception {
        Product product = new Wine();

        mockMvc.perform(get("/products/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("products/productform"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    public void postNewProductformTest() throws Exception {
        Product product = new Wine();
        product.setId(WINE_ID);

        when(productService.save(any())).thenReturn(product);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id","")
                .param("description","stuff goes here")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products/1/show"));
    }

    @Test
    public void getProductByIdTest() throws Exception {
        Product product = new Wine();
        product.setId(WINE_ID);

        when(productService.findProductById(anyLong())).thenReturn(product);

        mockMvc.perform(get("/products/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("products/show"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    public void getUpdateViewTest() throws Exception {
        Product product = new Wine();
        product.setId(WINE_ID);

        when(productService.findProductById(anyLong())).thenReturn(product);

        mockMvc.perform(get("/products/1/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("products/productform"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    public void deleteProductTest() throws Exception {
        mockMvc.perform(delete("/products/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products"));

        verify(productService, times(1)).deleteById(anyLong());
    }
}