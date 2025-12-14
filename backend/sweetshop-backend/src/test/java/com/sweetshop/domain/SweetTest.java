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
    @Test(expected = IllegalArgumentException.class)
public void shouldNotAllowNegativePrice() {
    new Sweet(
            "2",
            "Gulab Jamun",
            "Indian",
            -100.0,
            5
    );
}
@Test(expected = IllegalArgumentException.class)
public void shouldNotAllowNegativeQuantity() {
    new Sweet(
            "3",
            "Rasgulla",
            "Indian",
            200.0,
            -3
    );
}

}
