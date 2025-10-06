package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public List<Recommendation> recommendations = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Main app = new Main();
    while (true) {
      System.out.println("Choose an option: ");
      for (int i = 0; i < app.recommendations.size(); i++) {
        System.out.println((i + 1) + ". " + app.recommendations.get(i).getTargetAudience());
      }
      System.out.println((app.recommendations.size() + 1) + ". Add new recommendation");
      System.out.println((app.recommendations.size() + 2) + ". Exit");

      int choice = scanner.nextInt();
      if (choice == app.recommendations.size() + 1) {
        app.addRecommendation(scanner);
      } else if (choice == app.recommendations.size() + 2) {
        break;
      } else if (choice > 0 && choice <= app.recommendations.size()) {
        Recommendation selectedRecommendation = app.recommendations.get(choice - 1);
        while (true) {
          System.out.println("Selected: " + selectedRecommendation.getTargetAudience());
          System.out.println("1. List Books, 2. Add Book, 3. Remove Book, 4. Clone Recommendation, 5. Rename Recommendation, 6. Delete Recommendation, 7. Back");

          int subChoice = scanner.nextInt();
          switch (subChoice) {
            case 1:
              app.recommendations.get(choice - 1).listBooks();
              break;
            case 2:
              app.addBookToRecommendation(scanner, selectedRecommendation);
              break;
            case 3:
              System.out.print("Enter book index to remove: ");
              int bookIndex = scanner.nextInt();
              if (bookIndex > 0 && bookIndex <= selectedRecommendation.getBooks().size()) {
                selectedRecommendation.getBooks().remove(bookIndex - 1);
              } else {
                System.out.println("Invalid book index.");
              }
              break;
            case 4:
              Recommendation clonedRec = (Recommendation) selectedRecommendation.clone();
              clonedRec.setTargetAudience(selectedRecommendation.getTargetAudience() + " (Clone)");
              app.recommendations.add(clonedRec);
              System.out.println("Recommendation cloned.");
              break;
            case 5:
              System.out.print("Enter new target audience: ");
              String newAudience = scanner.next();
              selectedRecommendation.setTargetAudience(newAudience);
              break;
            case 6:
              app.recommendations.remove(choice - 1);
              System.out.println("Recommendation deleted.");
              break;
            default:
              System.out.println("Invalid choice. Please try again.");
          }
          if (subChoice == 7) {
            break;
          }
        }
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  public void addBookToRecommendation(Scanner scanner, Recommendation recommendation) {
    System.out.print("Enter book title: ");
    String title = scanner.next();
    System.out.print("Enter book author: ");
    String author = scanner.next();
    System.out.print("Enter book genre: ");
    String genre = scanner.next();
    System.out.print("Enter publication year: ");
    int year = scanner.nextInt();
    recommendation.getBooks().add(new Book(title, author, genre, year));
  }

  public void addRecommendation(Scanner scanner) {
    System.out.print("Enter target audience: ");
    String audience = scanner.next();
    recommendations.add(new Recommendation(audience));
  }
}
