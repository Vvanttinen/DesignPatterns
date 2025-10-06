package observer;

import java.util.Random;

public class WeatherStation extends Observable implements Runnable {
  private double temperature;

  public WeatherStation() {
    this.temperature = new Random().nextDouble(-30, 40);
  }

  @Override
  public void run() {
    while (true) {
      try {
        int delay = new Random().nextInt(1000, 5000);
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      double d = new Random().nextDouble(-1, 1);
      if ((this.temperature - d) < -30 || (this.temperature + d) > 40) {
        d = -d;
      }
      this.temperature += d;
      System.out.printf("WeatherStation: Temperature is %.1fc\n", temperature);
      notifyObservers(temperature);
    }
  }
}
