package command;

public class Commands {
  public static class MoveCursorUpCommand implements Command {
    private final Cursor cursor;
    public MoveCursorUpCommand(Cursor cursor) { this.cursor = cursor; }
    public void execute() { cursor.moveUp(); }
  }
  public static class MoveCursorDownCommand implements Command {
    private final Cursor cursor;
    public MoveCursorDownCommand(Cursor cursor) { this.cursor = cursor; }
    public void execute() { cursor.moveDown(); }
  }

  public static class MoveCursorLeftCommand implements Command {
    private final Cursor cursor;
    public MoveCursorLeftCommand(Cursor cursor) { this.cursor = cursor; }
    public void execute() { cursor.moveLeft(); }
  }

  public static class MoveCursorRightCommand implements Command {
    private final Cursor cursor;
    public MoveCursorRightCommand(Cursor cursor) { this.cursor = cursor; }
    public void execute() { cursor.moveRight(); }
  }

  public static class TogglePixelCommand implements Command {
    private final Cursor cursor;
    public TogglePixelCommand(Cursor cursor) { this.cursor = cursor; }
    public void execute() { cursor.toggle(); }
  }

  public static class GenerateCodeCommand implements Command {
    private final Cursor cursor;
    public GenerateCodeCommand(Cursor cursor) { this.cursor = cursor; }

    public void execute() {
      boolean[][] grid = cursor.getGrid();
      System.out.println("int[][] pixelArt = {");
      for (int y = 0; y < grid.length; y++) {
        System.out.print("    {");
        for (int x = 0; x < grid[y].length; x++) {
          System.out.print(grid[y][x] ? "1" : "0");
          if (x < grid[y].length - 1) System.out.print(", ");
        }
        System.out.println("}" + (y < grid.length - 1 ? "," : ""));
      }
      System.out.println("};");
    }
  }
}
