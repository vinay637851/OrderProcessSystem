package com.example.order;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void order_success_flow() {
        OrderService service = new OrderService(
                new FakePaymentProcessor(true),
                new FakeEmailService(true)
        );

        Order order = new Order("T1", 200);
        boolean result = service.placeOrder(order);

        assertTrue(result);
        assertTrue(order.isPaid());
        assertTrue(order.isEmailSent());
    }

    @Test
    void payment_failed_test() {
        OrderService service = new OrderService(
                new FakePaymentProcessor(false),
                new FakeEmailService(true)
        );

        Order order = new Order("T2", 200);
        boolean result = service.placeOrder(order);

        assertFalse(result);
        assertFalse(order.isPaid());
    }

    @Test
    void email_failed_test() {
        OrderService service = new OrderService(
                new FakePaymentProcessor(true),
                new FakeEmailService(false)
        );

        Order order = new Order("T3", 200);
        boolean result = service.placeOrder(order);

        assertFalse(result);
        assertTrue(order.isPaid());
        assertFalse(order.isEmailSent());
    }
}
