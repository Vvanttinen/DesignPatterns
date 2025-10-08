package command;

public class CursorController {
  private final Command moveLeft;
  private final Command moveRight;
  private final Command moveUp;
  private final Command moveDown;
  private final Command togglePixel;
  private final Command generateCode;

  public CursorController(Command moveLeft, Command moveRight, Command moveUp, Command moveDown, Command togglePixel, Command generateCode) {
    this.moveLeft = moveLeft;
    this.moveRight = moveRight;
    this.moveUp = moveUp;
    this.moveDown = moveDown;
    this.togglePixel = togglePixel;
    this.generateCode = generateCode;
  }

  public void moveLeft() { moveLeft.execute(); }
  public void moveRight() { moveRight.execute(); }
  public void moveUp() { moveUp.execute(); }
  public void moveDown() { moveDown.execute(); }
  public void togglePixel() { togglePixel.execute(); }
  public void generateCode() { generateCode.execute(); }
}
