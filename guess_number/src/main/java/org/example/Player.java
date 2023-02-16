package org.example;

public class Player {
    private Attempts attempts;
    private UserGuess userGuess;
    private boolean won;

    public Player(int maxAttempts) {
        this.won = false;
        this.attempts = new Attempts(maxAttempts);
        this.userGuess = null;
    }

    public void reset(Player player) {
        this.won = false;
        this.attempts = new Attempts(player.getMaxAttempts());
    }

    public int getMaxAttempts() {
        return attempts.getMaxAttempts();
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isWon() {
        return won;
    }

    public void makeGuess(String guessInput) {
        try {
            userGuess = new UserGuess(guessInput);
            attempts.incrementAttempts();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public int getAttempts() {
        return attempts.getAttempts();
    }

    public boolean isMaxAttempts() {
        return attempts.isMaxAttempts();
    }

    public int getGuess() {
        return userGuess.getGuess();
    }
}
