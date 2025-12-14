package com.sweetshop.service;

import com.sweetshop.domain.Sweet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SweetServiceTest {

    @Test
    public void shouldAddSweetAndRetrieveAllSweets() {
        SweetService service = new SweetService();

        Sweet sweet = new Sweet(
                "1",
                "Kaju Katli",
                "Indian",
                500.0,
                10
        );

        service.addSweet(sweet);

        List<Sweet> sweets = service.getAllSweets();

        assertEquals(1, sweets.size());
        assertEquals("Kaju Katli", sweets.get(0).getName());
    }
    @Test
public void shouldSearchSweetsByName() {
    SweetService service = new SweetService();

    service.addSweet(new Sweet("1", "Kaju Katli", "Indian", 500.0, 10));
    service.addSweet(new Sweet("2", "Gulab Jamun", "Indian", 200.0, 15));
    service.addSweet(new Sweet("3", "Chocolate Bar", "Western", 100.0, 20));

    List<Sweet> results = service.searchByName("kaju");

    assertEquals(1, results.size());
    assertEquals("Kaju Katli", results.get(0).getName());
}
@Test
public void shouldSearchSweetsByCategory() {
    SweetService service = new SweetService();

    service.addSweet(new Sweet("1", "Kaju Katli", "Indian", 500.0, 10));
    service.addSweet(new Sweet("2", "Brownie", "Western", 250.0, 5));
    service.addSweet(new Sweet("3", "Rasgulla", "Indian", 200.0, 8));

    List<Sweet> results = service.searchByCategory("indian");

    assertEquals(2, results.size());
}
@Test
public void shouldSearchSweetsByPriceRange() {
    SweetService service = new SweetService();

    service.addSweet(new Sweet("1", "Kaju Katli", "Indian", 500.0, 10));
    service.addSweet(new Sweet("2", "Gulab Jamun", "Indian", 200.0, 15));
    service.addSweet(new Sweet("3", "Chocolate", "Western", 100.0, 20));

    List<Sweet> results = service.searchByPriceRange(150.0, 400.0);

    assertEquals(1, results.size());
    assertEquals("Gulab Jamun", results.get(0).getName());
}

}
