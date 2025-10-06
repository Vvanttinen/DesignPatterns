package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
  private List<Observer> observers = new ArrayList<>();

  public synchronized void addObserver(Observer observer) {
    observers.add(observer);
  }

  public synchronized void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public synchronized void notifyObservers(double temp) {
    for (Observer observer : observers) {
      observer.update(temp);
    }
  }
}
