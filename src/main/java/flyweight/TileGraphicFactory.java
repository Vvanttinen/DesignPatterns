package flyweight;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TileGraphicFactory {
  private static final Map<String, Image> tileImages = new HashMap<>();

  public static Image getTileImage(String type) {
    if (!tileImages.containsKey(type)) {
      String path = switch (type) {
        case "building" -> "/resources/images/building.png";
        case "road" -> "/resources/images/road.png";
        case "forest" -> "/resources/images/forest.png";
        case "water" -> "/resources/images/water.png";
        case "swamp" -> "/resources/images/swamp.png";
        default -> throw new IllegalStateException("Unexpected value: " + type);
      };
      tileImages.put(type, new Image(Objects.requireNonNull(TileGraphicFactory.class.getResourceAsStream(path))));
    }
    return tileImages.get(type);
  }
}
