package com.hei.prog2.model;

import java.util.Objects;

public class OrderItem {

    private Garment garment;
    private int quantity;

    public OrderItem(Garment garment, int quantity) {
        this.garment = Objects.requireNonNull(garment, "Garment must not be null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive integer");
        }
        this.quantity = quantity;
    }

    public Garment getGarment() {
        return garment;
    }

    public void setGarment(Garment garment) {
        this.garment = garment;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getSubtotal() {
        return garment.getUnitPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("OrderItem[garment=%s, quantity=%d, subtotal=%.2f]",
                garment.getName(), quantity, getSubtotal());
    }
}
