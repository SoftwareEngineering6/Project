import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class writeToCsv {
  public static void download() {

    final String COMMA_DELIMITER = ",";
    final String NEW_LINE_SEPERATOR = "\n";
    final String FILE_HEADER = "student,score,timetaken,skipped";
    List<Integer> score = school.quizScore;
    List<Double> timetaken = school.timeTaken;
    List<Integer> skipped = school.skippedQuestions;

    try {
      Writer w = new FileWriter("output.csv");
      w.append(FILE_HEADER);
      w.append(NEW_LINE_SEPERATOR);

      for (int i=0; i < score.size(); i++) {
        w.append(String.valueOf(i+1));
        w.append(COMMA_DELIMITER);
        w.append(String.valueOf(score.get(i)));
        w.append(COMMA_DELIMITER);
        w.append(String.valueOf(timetaken.get(i)));
        w.append(COMMA_DELIMITER);
        w.append(String.valueOf(skipped.get(i)));
        w.append(NEW_LINE_SEPERATOR);
      }
      w.close();
      alertBox.noDetails("Download Complete!");

    } catch(IOException e) {
      e.printStackTrace();
    }

  }
}
