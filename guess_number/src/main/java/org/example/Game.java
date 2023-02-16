package org.example;

public class Game {
    private final Player player;
    private final int maxAttempts;
    private final RandomGenerator randomGenerator;
    private final Logger logger = Logger.getInstance();
    private final InputParser inputParser = InputParser.getInstance();
    private Boolean continuePlaying = true;


    public Game(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.player = new Player(maxAttempts);
        this.randomGenerator = new RandomGenerator();
    }

    public void launch() {
        logger.log("-===========================-");
        logger.log("=== GUESS THE NUMBER GAME ===");
        logger.log("-===========================-");

        logger.log("You have " + maxAttempts + " attempts to guess the number between 0 and 100.");
        logger.log("Guess the number (between 1 and 100) : ");
        while (continuePlaying) {
            continuePlaying = false;
            while (!player.isMaxAttempts()) {
                String guessInput = inputParser.parseInput();
                try {
                    player.makeGuess(guessInput);
                    if (randomGenerator.isCorrectGuess(player.getGuess())) {
                        player.setWon(true);
                        logger.log("You found it after " + player.getAttempts() + " tries!");
                        break;
                    }
                    logger.log("You have " + (maxAttempts - player.getAttempts()) + " attempts left.");
                } catch (NumberFormatException e) {
                    logger.log(e.getMessage());
                }
            }
            if (!player.isWon()) {
                logger.log("Sorry, you have reached the maximum number of attempts.");
                logger.log("You lost! The number was " + randomGenerator.getNumberToGuess());
            }

            logger.log("Do you want to play again? (y/n)");
            String userResponse = inputParser.parseInput();
            continuePlaying = userResponse.equals("y");
            if (continuePlaying) {
                player.reset(new Player(10));
                randomGenerator.reset();
                launch();
            }
        }
    }
}
