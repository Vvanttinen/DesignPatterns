package factory_method.tile;

public class SwampTile implements Tile {
  @Override
  public char getCharacter() {
    return 'S';
  }

  @Override
  public String getType() {
    return "swamp";
  }

  @Override
  public void action() {

  }
}
