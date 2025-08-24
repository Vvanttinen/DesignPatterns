package factory_method.tile;

public class BuildingTile implements Tile {
  @Override
  public char getCharacter() {
    return 'B';
  }

  @Override
  public String getType() {
    return "building";
  }

  @Override
  public void action() {

  }
}
