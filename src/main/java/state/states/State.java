package state.states;

import state.Character;

public abstract class State {
  private state.Character character;

  public State(state.Character character) {
    this.character = character;
  }

  public Character getCharacter() {
    return this.character;
  }

  public void action() {
    this.character.printStatus();
  }
}
