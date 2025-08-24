package factory_method.tile;

public class WaterTile implements Tile {
  @Override
  public char getCharacter() {
    return 'W';
  }

  @Override
  public String getType() {
    return "water";
  }

  @Override
  public void action() {

  }
}
