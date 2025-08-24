package factory_method.map;

import factory_method.tile.ForestTile;
import factory_method.tile.SwampTile;
import factory_method.tile.Tile;
import factory_method.tile.WaterTile;

public class WildernessMap extends Map {

  public WildernessMap(int width, int height) {
    super(width, height);
  }

  @Override
  public Tile createTile() {
    int random = rand.nextInt(3);
    return switch (random) {
      case 0 -> new SwampTile();
      case 1 -> new WaterTile();
      default -> new ForestTile();
    };
  }
}
