package visitor;

public class File implements FileSystemElement {
  private final String name;
  private final int sizeMB;

  public File(String name, int sizeMB) {
    this.name = name;
    this.sizeMB = sizeMB;
  }

  public String getName() {
    return name;
  }

  public int getSizeMB() {
    return sizeMB;
  }

  @Override
  public void accept(FileSystemVisitor visitor) {
    visitor.visit(this);
  }
}
