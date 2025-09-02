package template_method;

public class Main {
  public static void main(String[] args) {
    Game game = new NumberGuessGame();
    game.play(3); // Play a game with 3 players
  }
}
