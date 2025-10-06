package facade;

public class Main {
  public static void main(String[] args) {
    ApiFacade facade = new ApiFacade();

    try {
      // Chuck norris joke
      String joke = facade.getAttributeValueFromJson(
              "https://api.chucknorris.io/jokes/random",
              "value");
      System.out.println("Random Chuck Norris joke:");
      System.out.println(joke);

      // Exchange rate
      String rateBase = facade.getAttributeValueFromJson(
              "https://api.fxratesapi.com/latest",
              "base");
      System.out.println("\nExchange rate base currency:");
      System.out.println(rateBase);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}