package com.example.order;

public class Order {
    private final String id;
    private final double amount;
    private boolean paid;
    private boolean emailSent;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.paid = false;
        this.emailSent = false;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }

    public boolean isPaid() { return paid; }
    public void markPaid() { this.paid = true; }

    public boolean isEmailSent() { return emailSent; }
    public void markEmailSent() { this.emailSent = true; }
}
