package abstract_factory.uifactory;

import abstract_factory.button.Button;
import abstract_factory.button.ButtonB;
import abstract_factory.checkbox.Checkbox;
import abstract_factory.checkbox.CheckboxB;
import abstract_factory.textfield.TextField;
import abstract_factory.textfield.TextFieldB;

public class BFactory implements UIFactory {
  @Override
  public Button createButton(String text) {
    Button button = new ButtonB();
    button.setText(text);
    return button;
  }

  @Override
  public Checkbox createCheckbox(String text) {
    Checkbox checkbox = new CheckboxB();
    checkbox.setText(text);
    return checkbox;
  }

  @Override
  public TextField createTextField(String text) {
    TextField textField = new TextFieldB();
    textField.setText(text);
    return textField;
  }
}
