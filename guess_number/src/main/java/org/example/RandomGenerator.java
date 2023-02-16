package org.example;

public class RandomGenerator {

    private int numberToGuess;
    private final Logger logger = Logger.getInstance();

    public RandomGenerator() {
        numberToGuess = (int) (Math.random() * 100);
    }

    public void reset() {
        numberToGuess = (int) (Math.random() * 100);
    }

    public boolean isCorrectGuess(int guess) {
        if ( guess < numberToGuess ) {
            logger.log("Your guess is too low.");
        } else if ( guess > numberToGuess ) {
            logger.log("Your guess is too high.");
        }
        return guess == numberToGuess;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }
}
