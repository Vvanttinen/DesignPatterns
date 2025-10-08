package command;

public class Cursor {
  private int x, y;
  private boolean[][] grid;

  public Cursor(boolean[][] grid) {
    this.grid = grid;
    this.x = 0;
    this.y = 0;
  }

  public void moveUp() {
    if (y > 0) y--;
  }

  public void moveDown() {
    if (y < grid.length - 1) y++;
  }

  public void moveLeft() {
    if (x > 0) x--;
  }

  public void moveRight() {
    if (x < grid[0].length - 1) x++;
  }

  public void toggle() {
    grid[y][x] = !grid[y][x];
  }

  public boolean[][] getGrid() { return grid; }
  public int getX() { return x; }
  public int getY() { return y; }
}
