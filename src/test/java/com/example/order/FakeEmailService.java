package com.example.order;

public class FakeEmailService implements EmailService {
    private final boolean shouldSucceed;

    public FakeEmailService(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean sendEmail(String message) {
        return shouldSucceed;
    }
}
