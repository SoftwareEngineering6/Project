import java.io.*;

public class py_test {
  public static void main(String[] args) {
    try {
      Process p = Runtime.getRuntime().exec("python plots.py");
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }
  }
}
