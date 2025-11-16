package com.example.order;

public class OrderService {

    private final PaymentProcessor paymentProcessor;
    private final EmailService emailService;

    public OrderService(PaymentProcessor paymentProcessor, EmailService emailService) {
        this.paymentProcessor = paymentProcessor;
        this.emailService = emailService;
    }

    public boolean placeOrder(Order order) {
        boolean paymentDone = paymentProcessor.process(order.getAmount());
        if (!paymentDone) return false;
        order.markPaid();

        boolean emailSent = emailService.sendEmail("Order " + order.getId() + " confirmed");
        if (!emailSent) return false;

        order.markEmailSent();
        return true;
    }
}
