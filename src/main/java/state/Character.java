package state;

import state.states.NoviceState;
import state.states.State;

import java.util.Scanner;

public class Character {
  private static final Scanner scanner = new Scanner(System.in);
  private String name;
  private int experience;
  private int health;
  private State state;

  public Character(String name) {
    this.name = name;
    this.experience = 0;
    this.health = 100;
    this.state = new NoviceState(this);
  }

  public void setState(State state) {
    this.state = state;
  }

  public void doStuff() {
    while (true) {
      if (state == null) {
        System.out.println("No state assigned to character.");
        return;
      }
      state.action();
    }
  }

  public void train() {
    this.experience += 10;
  }

  public void meditate() {
    this.health += 10;
  }

  public void fight() {
    this.health -= 35;
    if (this.health <= 0) {
      System.out.println("You have been defeated in battle!");
      System.exit(0);
    }
    this.experience += 20;
  }

  public void printStatus() {
    System.out.println("======CHARACTER======");
    System.out.println("Name: " + this.name);
    System.out.println("Level: " + this.state);
    System.out.println("Experience: " + this.experience);
    System.out.println("Health: " + this.health);
    System.out.println("=====================");
  }

  public int getUserInput(String[] options) {
    System.out.println("Choose an action:");
    for (int i = 0; i < options.length; i++) {
      System.out.println((i + 1) + ". " + options[i]);
    }

    return scanner.nextInt();
  }

  public int getExperience() {
    return this.experience;
  }
}
