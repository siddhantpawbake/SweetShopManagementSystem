package com.sweetshop.service;

import com.sweetshop.domain.Sweet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
}
