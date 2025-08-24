package factory_method.map;

import factory_method.tile.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Map {
  protected int width;
  protected int height;
  protected Tile[][] tiles;
  protected static final Random rand = new Random();

  public Map(int width, int height) {
    this.width = width;
    this.height = height;
    tiles = new Tile[width][height];
    generateMap();
  }

  private void generateMap() {
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        tiles[i][j] = createTile();
      }
    }
  }

  public abstract Tile createTile();

  public void display() {
    List<String> types = new ArrayList<>();

    for (int j = 0; j < height; j++) {
      for (int i = 0; i < width; i++) {
        String type = tiles[i][j].getType();
        char character = tiles[i][j].getCharacter();
        System.out.print(character + " ");
        if (!types.contains(character + ": " + type)) {
          types.add(character + ": " + type);
        }
      }
      System.out.println();
    }

    System.out.println("Legend: \n" + String.join(", ", types));
  }
}
