package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
  private String extension;
  private List<File> foundFiles = new ArrayList<>();

  public SearchVisitor(String extension) {
    this.extension = extension;
  }

  public List<File> getFoundFiles() {
    return foundFiles;
  }

  @Override
  public void visit(File file) {
    if (file.getName().endsWith(extension)) {
      foundFiles.add(file);
    }
  }

  @Override
  public void visit(Directory directory) {
    for (FileSystemElement element : directory.getElements()) {
      element.accept(this);
    }
  }
}
