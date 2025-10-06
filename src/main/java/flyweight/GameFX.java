package flyweight;

import factory_method.Game;
import factory_method.map.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class GameFX extends Application {

  public void start(Stage stage) {
    int tileSize = 32;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Select map type: 1. City 2. Wilderness");
    int mapType = scanner.nextInt();
    System.out.println("Enter map width:");
    int width = scanner.nextInt();
    System.out.println("Enter map height:");
    int height = scanner.nextInt();

    Game game = new Game();
    Map map = game.createMap(mapType, width, height);

    Canvas canvas = new Canvas(width * tileSize, height * tileSize);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    map.render(gc, tileSize);

    StackPane root = new StackPane(canvas);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("RPG Map");
    stage.show();
  }
}
