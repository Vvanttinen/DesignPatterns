package state.states;

import state.Character;

public class NoviceState extends State {

  public NoviceState(Character character) {
    super(character);
  }

  @Override
  public void action() {
    super.action();
    if (this.getCharacter().getExperience() >= 20) {
      this.getCharacter().setState(new IntermediateState(this.getCharacter()));
      System.out.println("You have leveled up to Intermediate!");
      return;
    }

    String[] options = {"Train"};
    if (this.getCharacter().getUserInput(options) == 1) {
      this.getCharacter().train();
    }
  }

  @Override
  public String toString() {
    return "Novice";
  }
}
