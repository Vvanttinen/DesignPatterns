package adapter;

public class Main {
  public static void main(String[] args) {
    NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

    dateAdapter.setYear(2025);
    dateAdapter.setMonth(9);
    dateAdapter.setDay(24);

    System.out.println("Initial date: " +
            dateAdapter.getDay() + "/" + (dateAdapter.getMonth() + 1) + "/" + dateAdapter.getYear());

    dateAdapter.advanceDays(10);

    System.out.println("date after advancing 10 days: " +
            dateAdapter.getDay() + "/" + (dateAdapter.getMonth() + 1) + "/" + dateAdapter.getYear());
  }
}
