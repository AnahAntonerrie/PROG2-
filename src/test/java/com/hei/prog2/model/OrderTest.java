package com.hei.prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {

    private Client client;
    private Top tShirt;
    private Bottom jeans;

    @BeforeEach
    void setUp() {
        client = new Client(
                "ANDRIANAH",
                "Anah",
                LocalDate.of(2007, 7, 11),
                "Antananarivo",
                "hei.anah@gmail.com",
                "0320900009"
        );

        tShirt = new Top("T-Shirt", Size.M, 15.0, Material.COTTON, SleeveType.SHORT);

        jeans = new Bottom("Jeans", Size.L, 25.0, Material.OTHER, 32);
    }

    @Test
    void totalAmount_shouldBeZero_whenOrderHasNoItems() {
        Order order = new Order(client, LocalDate.of(2026, 9, 18), "Empty order");

        assertEquals(0.0, order.getTotalAmount(), 0.0001,
                "An order with no items should have a total amount of 0");
    }

    @Test
    void totalAmount_shouldSumUnitPriceTimesQuantity_forEachItem() {
        Order order = new Order(client, LocalDate.of(2026, 9, 18), "Mixed order");

        order.addItem(tShirt, 3);
        order.addItem(jeans, 2);

        assertEquals(95.0, order.getTotalAmount(), 0.0001,
                "Total amount must equal the sum of (unit price * quantity) for every item");
    }

    @Test
    void totalAmount_shouldUpdate_whenAnotherItemIsAdded() {
        Order order = new Order(client, LocalDate.of(2026, 9, 18), "Growing order");

        order.addItem(tShirt, 1); // 15.0
        assertEquals(15.0, order.getTotalAmount(), 0.0001);

        order.addItem(jeans, 4); // + 100.0
        assertEquals(115.0, order.getTotalAmount(), 0.0001);
    }

    @Test
    void addItem_shouldRejectNonPositiveQuantity() {
        Order order = new Order(client, LocalDate.of(2026, 9, 18), "Invalid order");

        assertThrows(IllegalArgumentException.class, () -> order.addItem(tShirt, 0));
        assertThrows(IllegalArgumentException.class, () -> order.addItem(tShirt, -1));
    }
}
