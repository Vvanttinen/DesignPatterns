package bridge;

public class SmartTv extends Tv {
  public void browseInternet() {
    if (isEnabled()) {
      System.out.println("Browsing the internet on the smart TV...");
    } else {
      System.out.println("Turn on the TV to browse the internet.");
    }
  }

  @Override
  public void printStatus() {
    System.out.println("------------------------------------");
    System.out.println("| I'm a smart TV.");
    super.printStatus();
    System.out.println("| Smart features: Enabled");
    System.out.println("------------------------------------\n");
  }
}
