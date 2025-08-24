package factory_method;

import factory_method.map.CityMap;
import factory_method.map.Map;
import factory_method.map.WildernessMap;

import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Select map type: 1. City 2. Wilderness");
    int mapType = scanner.nextInt();
    System.out.println("Enter map width:");
    int width = scanner.nextInt();
    System.out.println("Enter map height:");
    int height = scanner.nextInt();

    scanner.close();

    Game game = new Game();
    Map map = game.createMap(mapType, width, height);
    map.display();
  }

  public Map createMap(int mapType, int width, int height) {
    switch(mapType) {
      case 1 -> {
        return new CityMap(width, height);
      }
      case 2 -> {
        return new WildernessMap(width, height);
      }
      default -> throw new IllegalArgumentException("Invalid map type");
    }
  }
}
