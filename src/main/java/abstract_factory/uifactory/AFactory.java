package abstract_factory.uifactory;

import abstract_factory.button.Button;
import abstract_factory.button.ButtonA;
import abstract_factory.checkbox.Checkbox;
import abstract_factory.checkbox.CheckboxA;
import abstract_factory.textfield.TextField;
import abstract_factory.textfield.TextFieldA;

public class AFactory implements UIFactory {
  @Override
  public Button createButton(String text) {
    Button button = new ButtonA();
    button.setText(text);
    return button;
  }

  @Override
  public Checkbox createCheckbox(String text) {
    Checkbox checkbox = new CheckboxA();
    checkbox.setText(text);
    return checkbox;
  }

  @Override
  public TextField createTextField(String text) {
    TextField textField = new TextFieldA();
    textField.setText(text);
    return textField;
  }
}
