package prototype;

public class Book implements Prototype {
  private String title;
  private String author;
  private String genre;
  private int publicationYear;

  public Book(String title, String author, String genre, int publicationYear) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publicationYear = publicationYear;
  }

  @Override
  public Prototype clone() {
    return new Book(title, author, genre, publicationYear);
  }

  @Override
  public String toString() {
    return String.format("%s by %s (%s, %d)", title, author, genre, publicationYear);
  }
}
