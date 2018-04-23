import java.io.*;
import java.util.ArrayList;

public class writeToCsv {
  public static void main(String[] args) {
    final String COMMA_DELIMITER = ",";
    final String NEW_LINE_SEPERATOR = "\n";
    final String FILE_HEADER = "student,question,response,time";
    testdummydata d = new testdummydata();
    ArrayList<ArrayList<Response>> data = d.testData();
    try {
      Writer w = new FileWriter("output.csv");
      w.append(FILE_HEADER);
      w.append(NEW_LINE_SEPERATOR);
      for (int i = 0; i < data.size(); i++) {
        for (int j = 0; j < data.get(i).size(); j++) {
          w.append(String.valueOf(i));
          w.append(COMMA_DELIMITER);
          w.append(String.valueOf(j));
          w.append(COMMA_DELIMITER);
          w.append(data.get(i).get(j).answer);
          w.append(COMMA_DELIMITER);
          w.append(String.valueOf(data.get(i).get(j).timetaken));
          w.append(NEW_LINE_SEPERATOR);
        }
      }
      w.close();
      System.out.println("Written to File");

    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
