package abstract_factory.button;

public class ButtonB extends Button {

  @Override
  public void display() {
    int width = text.length() + 4;
    System.out.println("+" + "/".repeat(width - 2) + "+");
    System.out.println("| " + text + " |");
    System.out.println("+" + "/".repeat(width - 2) + "+");
  }
}
