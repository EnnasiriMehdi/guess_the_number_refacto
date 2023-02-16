package org.example;

public class Attempts {
    private int attempts;
    private int maxAttempts;

    public Attempts(int maxAttempts) {
        this.attempts = 0;
        this.maxAttempts = maxAttempts;
    }

    public void incrementAttempts() {
        attempts++;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public boolean isMaxAttempts() {
        return attempts == maxAttempts;
    }
}
