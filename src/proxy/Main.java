package proxy;

public class Main {
  public static void main(String[] args) {
    Library library = new Library();

    User user1 = new User("TestiMies");
    User user2 = new User("Admin");

    library.addDocument(1, "This is a public document.");
    library.addProtectedDocument(2, "This is a protected document.", new String[]{"Admin"});

    try {
      System.out.println("User1 accessing doc1's content: " + library.getDocument(1).getContent(user1));
      System.out.println("User2 accessing doc1's content: " + library.getDocument(2).getContent(user2));

      System.out.println("User1 accessing doc2's creation date: " + library.getDocument(2).getCreationDate());
      System.out.println("User2 accessing doc2's creation date: " + library.getDocument(2).getCreationDate());

      System.out.println("User2 accessing doc2's content: " + library.getDocument(2).getContent(user2));
      System.out.println("User1 accessing doc2's content: " + library.getDocument(2).getContent(user1));
    } catch (AccessDeniedException e) {
      System.out.println(e.getMessage());
    }
  }
}
