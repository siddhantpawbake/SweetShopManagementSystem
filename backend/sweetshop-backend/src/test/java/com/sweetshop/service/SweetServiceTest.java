package com.sweetshop.service;

import com.sweetshop.domain.Sweet;
import com.sweetshop.repository.SweetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SweetServiceTest {

    private SweetRepository sweetRepository;
    private SweetService sweetService;

    @BeforeEach
    void setUp() {
        sweetRepository = Mockito.mock(SweetRepository.class);
        sweetService = new SweetService(sweetRepository);
    }

    @Test
    public void shouldAddSweetAndRetrieveAllSweets() {
        Sweet sweet = new Sweet("1", "Kaju Katli", "Indian", 500.0, 10);

        when(sweetRepository.save(any(Sweet.class))).thenReturn(sweet);
        when(sweetRepository.findAll()).thenReturn(List.of(sweet));

        sweetService.addSweet(sweet);

        List<Sweet> sweets = sweetService.getAllSweets();

        assertEquals(1, sweets.size());
        assertEquals("Kaju Katli", sweets.get(0).getName());
    }

    @Test
    public void shouldSearchSweetsByName() {
        Sweet sweet = new Sweet("1", "Kaju Katli", "Indian", 500.0, 10);

        when(sweetRepository.findByNameContainingIgnoreCase("kaju"))
                .thenReturn(List.of(sweet));

        List<Sweet> results = sweetService.searchByName("kaju");

        assertEquals(1, results.size());
        assertEquals("Kaju Katli", results.get(0).getName());
    }

    @Test
    public void shouldSearchSweetsByCategory() {
        when(sweetRepository.findByCategoryIgnoreCase("indian"))
                .thenReturn(List.of(
                        new Sweet("1", "Kaju Katli", "Indian", 500, 10),
                        new Sweet("2", "Rasgulla", "Indian", 200, 5)
                ));

        List<Sweet> results = sweetService.searchByCategory("indian");

        assertEquals(2, results.size());
    }

    @Test
    public void shouldSearchSweetsByPriceRange() {
        Sweet sweet = new Sweet("2", "Gulab Jamun", "Indian", 200, 15);

        when(sweetRepository.findByPriceBetween(150, 400))
                .thenReturn(List.of(sweet));

        List<Sweet> results = sweetService.searchByPriceRange(150, 400);

        assertEquals(1, results.size());
        assertEquals("Gulab Jamun", results.get(0).getName());
    }
}
