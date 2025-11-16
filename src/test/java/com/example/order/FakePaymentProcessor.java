package com.example.order;

public class FakePaymentProcessor implements PaymentProcessor {
    private final boolean shouldSucceed;

    public FakePaymentProcessor(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean process(double amount) {
        return shouldSucceed;
    }
}
