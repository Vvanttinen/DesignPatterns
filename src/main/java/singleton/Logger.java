package singleton;

import java.io.FileWriter;

public class Logger {
  private static Logger instance;
  private FileWriter fw;

  private Logger() {
    try {
      fw = new FileWriter("default_log.txt", true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
    }
    return instance;
  }

  public void setFileName(String fileName) {
    try {
      if (fw != null) {
        fw.close();
      }
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
