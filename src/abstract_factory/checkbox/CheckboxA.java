package abstract_factory.checkbox;

public class CheckboxA extends Checkbox {
  @Override
  public void display() {
    System.out.println(text + " [ ]");
  }
}
