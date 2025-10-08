package command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application {
  private static final int GRID_SIZE = 8;
  private static final int CELL_SIZE = 50;

  private Cursor cursor;
  private Canvas canvas;
  private CursorController cursorController;

  @Override
  public void start(Stage stage) throws Exception {
    boolean[][] grid = new boolean[GRID_SIZE][GRID_SIZE];
    cursor = new Cursor(grid);

    cursorController = new CursorController(
            new Commands.MoveCursorLeftCommand(cursor),
            new Commands.MoveCursorRightCommand(cursor),
            new Commands.MoveCursorUpCommand(cursor),
            new Commands.MoveCursorDownCommand(cursor),
            new Commands.TogglePixelCommand(cursor),
            new Commands.GenerateCodeCommand(cursor)
    );

    canvas = new Canvas(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
    canvas.setFocusTraversable(true);
    canvas.requestFocus();

    Button generateButton = new Button("Generate Code");
    generateButton.setFocusTraversable(false); // Prevent button from stealing focus
    generateButton.setOnAction(e -> cursorController.generateCode());

    VBox controls = new VBox(generateButton);
    controls.setAlignment(javafx.geometry.Pos.CENTER);
    BorderPane root = new BorderPane();
    root.setCenter(canvas);
    root.setBottom(controls);

    Scene scene = new Scene(root);
    stage.setTitle("Pixel Art Editor");
    stage.setScene(scene);
    stage.show();

    drawGrid();

    // Handle keyboard input
    scene.setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case UP -> cursorController.moveUp();
        case DOWN -> cursorController.moveDown();
        case LEFT -> cursorController.moveLeft();
        case RIGHT -> cursorController.moveRight();
        case SPACE -> cursorController.togglePixel();
        default -> { return; }
      }
      drawGrid();
    });
  }

  private void drawGrid() {
    GraphicsContext gc = canvas.getGraphicsContext2D();

    gc.setFill(javafx.scene.paint.Color.WHITE);
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

    boolean[][] grid = cursor.getGrid();

    // Draw pixels
    for (int y = 0; y < GRID_SIZE; y++) {
      for (int x = 0; x < GRID_SIZE; x++) {
        if (grid[y][x]) {
          gc.setFill(javafx.scene.paint.Color.BLACK);
          gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
        gc.setStroke(javafx.scene.paint.Color.GRAY);
        gc.strokeRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
      }
    }

    // Draw cursor
    gc.setStroke(javafx.scene.paint.Color.RED);
    gc.setLineWidth(3);
    gc.strokeRect(cursor.getX() * CELL_SIZE, cursor.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
  }
}
