package com.hei.prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Client client;
    private LocalDate orderDate;
    private String description;
    private List<OrderItem> items;

    public Order(Client client, LocalDate orderDate, String description) {
        this.client = Objects.requireNonNull(client, "Client must not be null");
        this.orderDate = Objects.requireNonNull(orderDate, "Order date must not be null");
        this.description = description;
        this.items = new ArrayList<>();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItem> getItems() {
        return items;
    }


    public void addItem(Garment garment, int quantity) {
        items.add(new OrderItem(garment, quantity));
    }


    public double getTotalAmount() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("Order[client=%s %s, orderDate=%s, description=%s, items=%d, total=%.2f]",
                client.getFirstName(), client.getLastName(), orderDate, description,
                items.size(), getTotalAmount());
    }
}
