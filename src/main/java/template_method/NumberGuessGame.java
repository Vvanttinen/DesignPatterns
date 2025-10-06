package template_method;

public class NumberGuessGame extends Game {
  private int numberToGuess;
  private int maxAttempts;
  private int currentAttempt;
  private boolean hasWinner;

  @Override
  public void initializeGame(int numberOfPlayers) {
    numberToGuess = (int) (Math.random() * 100) + 1;
    maxAttempts = 10;
    currentAttempt = 0;
    hasWinner = false;
    System.out.println("Guess the number between 1 and 100.");
  }

  @Override
  public boolean endOfGame() {
    return hasWinner || currentAttempt >= maxAttempts;
  }

  @Override
  public void playSingleTurn(int player) {
    currentAttempt++;
    int guess = (int) (Math.random() * 100) + 1;
    System.out.println("Player " + player + " guesses: " + guess);
    if (guess == numberToGuess) {
      hasWinner = true;
      System.out.println("Player " + player + " guessed the correct number!");
    } else if (guess < numberToGuess) {
      System.out.println("Too low!");
    } else {
      System.out.println("Too high!");
    }
  }

  @Override
  public void displayWinner() {
    if (hasWinner) {
      System.out.println("Winner Winner Chicken Dinner!");
    } else {
      System.out.println("No one guessed the number. The correct number was: " + numberToGuess);
    }
  }
}
