package org.example;

public class UserGuess {
    private final int guess;

    public UserGuess(String guessInput) {
        try {
            this.guess = Integer.parseInt(guessInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Your input was '" + guessInput + "', please enter a valid integer.");
        }
    }
    public int getGuess() {
        return guess;
    }
}
