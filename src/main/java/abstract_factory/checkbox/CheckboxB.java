package abstract_factory.checkbox;

public class CheckboxB extends Checkbox {
  @Override
  public void display() {
    System.out.println(text + " { }");
  }
}
