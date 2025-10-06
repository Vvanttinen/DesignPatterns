package factory_method.tile;

public class ForestTile implements Tile {
  @Override
  public char getCharacter() {
    return 'F';
  }

  @Override
  public String getType() {
    return "forest";
  }

  @Override
  public void action() {

  }
}
