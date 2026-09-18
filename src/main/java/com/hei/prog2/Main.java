package com.hei.prog2;

import com.hei.prog2.model.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Client client = new Client(
                "ANDRIANAH",
                "ANAH",
                LocalDate.of(2007, 7, 11),
                "Antananarivo",
                "hei.anah@gmail.com",
                "0320900009"
        );

        Top tShirt = new Top("T-Shirt", Size.M, 15.0, Material.COTTON, SleeveType.SHORT);
        Bottom jeans = new Bottom("Jeans", Size.L, 25.0, Material.OTHER, 32);

        Order order = new Order(client, LocalDate.now(), "Fall clothing order");
        order.addItem(tShirt, 3);
        order.addItem(jeans, 2);

        System.out.println(order);
        System.out.printf("Total amount: %.2f%n", order.getTotalAmount());
    }
}
