package observer;

public class Main {
  public static void main(String[] args) {
    Observer observer1 = new WeatherObserver();
    Observer observer2 = new WeatherObserver();
    Observer observer3 = new WeatherObserver();

    WeatherStation weatherStation = new WeatherStation();

    weatherStation.addObserver(observer1);
    weatherStation.addObserver(observer2);
    weatherStation.addObserver(observer3);

    new Thread(weatherStation).start();

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    weatherStation.removeObserver(observer2);
    System.out.println("Observer 2 removed");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.exit(0);
  }
}
