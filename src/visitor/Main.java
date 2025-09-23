package visitor;

public class Main {
  public static void main(String[] args) {
    // Create directory structure
    Directory root = new Directory("root");
    File file1 = new File("document.txt", 5);
    File file2 = new File("photo.jpg", 15);
    File file3 = new File("video.mp4", 200);

    Directory subDir = new Directory("subfolder");
    File file4 = new File("notes.txt", 3);

    // Build hierarchy
    root.addElement(file1);
    root.addElement(file2);
    root.addElement(file3);
    subDir.addElement(file4);
    root.addElement(subDir);

    // Visitor 1: Calculate total size
    SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
    root.accept(sizeVisitor);
    System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

    // Visitor 2: Search for .txt files
    SearchVisitor searchVisitor = new SearchVisitor(".txt");
    root.accept(searchVisitor);
    System.out.println("Found .txt files:");
    for (File f : searchVisitor.getFoundFiles()) {
      System.out.println(" - " + f.getName() + " (" + f.getSizeMB() + " MB)");
    }
  }
}
