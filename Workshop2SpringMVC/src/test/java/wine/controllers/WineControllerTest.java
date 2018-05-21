package wine.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import wine.domain.Wine;
import wine.services.WineService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class WineControllerTest {

    private static final Long WINE_ID = 1l;

    @Mock
    WineService wineService;
    
    WineController wineController;
    
    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        wineController = new WineController(wineService);
        mockMvc = MockMvcBuilders.standaloneSetup(wineController).build();
    }

    @Test
    public void getWineformTest() throws Exception {
        Wine wine = new Wine();

        mockMvc.perform(get("/products/wines/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("products/wines/wineform"))
                .andExpect(model().attributeExists("wine"));
    }

    @Test
    public void postNewWineformTest() throws Exception {
        Wine wine = new Wine();
        wine.setId(WINE_ID);

        when(wineService.save(any())).thenReturn(wine);

        mockMvc.perform(post("/wine")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED) 
                .param("id","1")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products/wines/1/show"));
    }

    @Test
    public void getWineByIdTest() throws Exception {
        Wine wine = new Wine();
        wine.setId(WINE_ID);

        when(wineService.findWineById(anyLong())).thenReturn(wine);

        mockMvc.perform(get("/products/wines/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("products/wines/show"))
                .andExpect(model().attributeExists("wine"));
    }

    @Test
    public void getUpdateViewTest() throws Exception {
        Wine wine = new Wine();
        wine.setId(WINE_ID);

        when(wineService.findWineById(anyLong())).thenReturn(wine);

        mockMvc.perform(get("/products/wines/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("products/wines/wineform"))
                .andExpect(model().attributeExists("wine"));
    }

    @Test
    public void deleteWineTest() throws Exception {
        mockMvc.perform(get("/products/wines/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products/wines/all"));

        verify(wineService, times(1)).deleteById(anyLong());
    }
}