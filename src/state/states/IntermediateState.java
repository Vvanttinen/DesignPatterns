package state.states;

import state.Character;

public class IntermediateState extends State {

  public IntermediateState(Character character) {
    super(character);
  }

  @Override
  public void action() {
    super.action();
    if (this.getCharacter().getExperience() >= 50) {
      this.getCharacter().setState(new ExpertState(this.getCharacter()));
      System.out.println("You have leveled up to Expert!");
      return;
    }

    String[] options = {"Train", "Meditate"};
    switch (this.getCharacter().getUserInput(options)) {
      case 1 -> this.getCharacter().train();
      case 2 -> this.getCharacter().meditate();
    }
  }

  @Override
  public String toString() {
    return "Intermediate";
  }
}
