package observer;

public class WeatherObserver implements Observer {
  private double temperature;

  @Override
  public void update(double temperature) {
    this.temperature = temperature;
    System.out.printf("WeatherObserver: Temperature updated to %.1fc\n", temperature);
  }
}
