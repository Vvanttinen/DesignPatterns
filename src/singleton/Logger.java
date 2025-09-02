package singleton;

import java.io.FileWriter;

public class Logger {
  private static Logger instance;
  private FileWriter fw;

  private Logger() {

  }

  public static Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
    }
    return instance;
  }

  public void setFileName(String fileName) {
    try {
      fw = new FileWriter(fileName, true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void write(String message) {
    try {
      fw.write(message + "\n");
      fw.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      fw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
