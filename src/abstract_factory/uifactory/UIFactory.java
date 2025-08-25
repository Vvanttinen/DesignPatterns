package abstract_factory.uifactory;

import abstract_factory.button.Button;
import abstract_factory.checkbox.Checkbox;
import abstract_factory.textfield.TextField;

public interface UIFactory {
  Button createButton(String text);
  Checkbox createCheckbox(String text);
  TextField createTextField(String text);
}
