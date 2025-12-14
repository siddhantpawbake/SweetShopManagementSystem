package com.sweetshop.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class SweetTest {

    @Test
    public void shouldCreateSweetWithValidDetails() {
        Sweet sweet = new Sweet(
                "1",
                "Kaju Katli",
                "Indian",
                500.0,
                10
        );

        assertEquals("1", sweet.getId());
        assertEquals("Kaju Katli", sweet.getName());
        assertEquals("Indian", sweet.getCategory());
        assertEquals(500.0, sweet.getPrice(), 0.001);
        assertEquals(10, sweet.getQuantity());
    }
}
