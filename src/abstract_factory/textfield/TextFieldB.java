package abstract_factory.textfield;

public class TextFieldB extends TextField {
  @Override
  public void display() {
    System.out.println(text);
    System.out.println("+//////////+");
    System.out.println("|          |");
    System.out.println("+//////////+");
  }
}
