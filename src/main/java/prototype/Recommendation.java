package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype {
  private String targetAudience;
  private List<Book> recommendedBooks;

  public Recommendation(String targetAudience) {
    this.targetAudience = targetAudience;
    this.recommendedBooks = new ArrayList<>();
  }

  public void setRecommendedBooks(List<Book> recommendedBooks) {
    this.recommendedBooks = recommendedBooks;
  }

  public void setTargetAudience(String targetAudience) {
    this.targetAudience = targetAudience;
  }
  public String getTargetAudience() {
    return targetAudience;
  }

  @Override
  public Prototype clone() {
    List<Book> clonedBooks = new ArrayList<>();
    for (Book book : recommendedBooks) {
      clonedBooks.add((Book) book.clone());
    }

    Recommendation clonedRecommendation = new Recommendation("");
    clonedRecommendation.setRecommendedBooks(clonedBooks);
    return clonedRecommendation;
  }

  public void listBooks() {
    System.out.println("Recommended Books for " + targetAudience + ":");
    for (int i = 0; i < recommendedBooks.size(); i++) {
      System.out.println((i + 1) + ". " + recommendedBooks.get(i));
    }
  }

  public List<Book> getBooks() {
    return recommendedBooks;
  }
}
