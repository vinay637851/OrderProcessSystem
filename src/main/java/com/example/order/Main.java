package com.example.order;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor pp = amount -> amount < 1000;
        EmailService es = message -> true;

        OrderService service = new OrderService(pp, es);
        Order order = new Order("O1", 500);

        System.out.println("Order placed: " + service.placeOrder(order));
    }
}
