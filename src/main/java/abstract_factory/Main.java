package abstract_factory;

import abstract_factory.uifactory.AFactory;
import abstract_factory.uifactory.BFactory;
import abstract_factory.uifactory.UIFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Choose a theme (1: Theme A, 2: Theme B): ");
    int choice = sc.nextInt();

    UIFactory uiFactory;
    switch (choice) {
      case 1 -> {
        uiFactory = new AFactory();
      }
      case 2 -> {
        uiFactory = new BFactory();
      }
      default -> throw new IllegalArgumentException("Invalid theme choice");
    }

    List<UIElement> components = new ArrayList<>();
    while (true) {
      System.out.println("Create component: 1, Rename component: 2, Exit: 0");
      int userInput = sc.nextInt();
      switch (userInput) {
        case 1 -> components.add(createComponent(uiFactory, sc));
        case 2 -> renameComponent(components, sc);
        case 0 -> {
          System.out.println("Exiting...");
          sc.close();
          return;
        }
      }

      for (UIElement component : components) {
        component.display();
      }
    }
  }

  private static void renameComponent(List<UIElement> components, Scanner sc) {
    if (components.isEmpty()) {
      System.out.println("No components to rename");
      return;
    }

    System.out.println("Enter the index of the component to rename (0 to " + (components.size() - 1) + "): ");
    int index = sc.nextInt();
    if (index < 0 || index >= components.size()) {
      System.out.println("Invalid index");
      return;
    }
    System.out.println("Enter new text for the component: ");
    String newText = sc.next();
    components.get(index).setText(newText);
  }

  private static UIElement createComponent(UIFactory uiFactory, Scanner sc) {
    System.out.println("Choose a component to create (1: Button, 2: Checkbox, 3: TextField): ");
    int componentChoice = sc.nextInt();
    System.out.println("Enter text for the component: ");
    String text = sc.next();

    switch (componentChoice) {
      case 1 -> {
        return uiFactory.createButton(text);
      }
      case 2 -> {
        return uiFactory.createCheckbox(text);
      }
      case 3 -> {
        return uiFactory.createTextField(text);
      }
      default -> {
        System.out.println("Invalid component choice");
        return null;
      }
    }
  }
}
