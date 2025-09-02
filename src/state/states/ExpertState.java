package state.states;

public class ExpertState extends State {

  public ExpertState(state.Character character) {
    super(character);
  }

  @Override
  public void action() {
    super.action();
    if (this.getCharacter().getExperience() >= 100) {
      System.out.println("You have leveled up to Master!");
      System.exit(0);
      return;
    }

    String[] options = {"Train", "Meditate", "Fight"};
    switch (this.getCharacter().getUserInput(options)) {
      case 1 -> this.getCharacter().train();
      case 2 -> this.getCharacter().meditate();
      case 3 -> this.getCharacter().fight();
    }
  }

  @Override
  public String toString() {
    return "Expert";
  }
}
