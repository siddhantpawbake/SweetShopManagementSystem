package com.sweetshop.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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
@Test
public void shouldNotAllowNegativePrice() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Sweet(
                "2",
                "Gulab Jamun",
                "Indian",
                -100.0,
                5
        );
    });
}

@Test
public void shouldNotAllowNegativeQuantity() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Sweet(
                "3",
                "Rasgulla",
                "Indian",
                200.0,
                -3
        );
    });
}

@Test
public void shouldDecreaseQuantityWhenPurchased() {
    Sweet sweet = new Sweet(
            "4",
            "Barfi",
            "Indian",
            300.0,
            5
    );

    sweet.purchase();

    assertEquals(4, sweet.getQuantity());
}
@Test
public void shouldNotAllowPurchaseWhenOutOfStock() {
    Sweet sweet = new Sweet(
            "5",
            "Peda",
            "Indian",
            150.0,
            0
    );

    assertThrows(IllegalStateException.class, sweet::purchase);
}

@Test
public void shouldIncreaseQuantityWhenRestocked() {
    Sweet sweet = new Sweet(
            "6",
            "Ladoo",
            "Indian",
            100.0,
            5
    );

    sweet.restock(10);

    assertEquals(15, sweet.getQuantity());
}
@Test
public void shouldNotAllowRestockWithNonPositiveQuantity() {
    Sweet sweet = new Sweet(
            "7",
            "Halwa",
            "Indian",
            120.0,
            3
    );

    assertThrows(IllegalArgumentException.class, () -> sweet.restock(0));
}



}
