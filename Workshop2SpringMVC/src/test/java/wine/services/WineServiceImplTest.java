package wine.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wine.domain.Wine;
import wine.repositories.WineRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class WineServiceImplTest {

    public static final Long WINE_ID = 1L;

    WineServiceImpl wineService;

    @Mock
    WineRepository wineRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        wineService = new WineServiceImpl(wineRepository);
    }

    @Test
    public void saveWineTest() {
        Wine wine = new Wine();

        when(wineRepository.save(any())).thenReturn(wine);

        Wine wineSaved = wineService.save(wine);
        assertNotNull(wineSaved);
        verify(wineRepository,times(1)).save(any());
    }

    @Test
    public void getWineByIdTest() {
        Wine wine = new Wine();
        wine.setId(WINE_ID);
        Optional<Wine> wineOptional = Optional.of(wine);

        when(wineRepository.findById(anyLong())).thenReturn(wineOptional);

        Wine wineRetrieved = wineService.findWineById(WINE_ID);
        assertNotNull(wineRetrieved);
        verify(wineRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getAllWinesTest() {
        HashSet<Wine> productsData = new HashSet<>();
        productsData.add(new Wine());

        when(wineService.findAllWines()).thenReturn(productsData);

        Set<Wine> products = (Set<Wine>)wineService.findAllWines();
        assertEquals(products.size(), 1);
        verify(wineRepository, times(1)).findAll();
    }

    @Test
    public void deleteWineTest() {
        Long idToDelete = Long.valueOf(WINE_ID);
        wineService.deleteById(idToDelete);

        // method is void so no when clause needed

        verify(wineRepository,times(1)).deleteById(idToDelete);
    }
}