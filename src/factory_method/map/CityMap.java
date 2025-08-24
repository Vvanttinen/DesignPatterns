package factory_method.map;

import factory_method.tile.BuildingTile;
import factory_method.tile.ForestTile;
import factory_method.tile.RoadTile;
import factory_method.tile.Tile;

public class CityMap extends Map {

  public CityMap(int width, int height) {
    super(width, height);
  }

  @Override
  public Tile createTile() {
    int random = rand.nextInt(3);
    return switch (random) {
      case 0 -> new RoadTile();
      case 1 -> new ForestTile();
      default -> new BuildingTile();
    };
  }
}
