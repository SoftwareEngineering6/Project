import java.io.*;

public class WriteToCsv {
  public static void download() {

    final String COMMA_DELIMITER = ",";
    final String NEW_LINE_SEPERATOR = "\n";
    final String FILE_HEADER = "student,score,timetaken,skipped";

    try {
      Writer w = new FileWriter("output.csv");
      
      for(School a : Main.choiceBox.getItems()) {
    	  	w.append(String.valueOf(a.schoolName));
    	    w.append(NEW_LINE_SEPERATOR);
    	    w.append(NEW_LINE_SEPERATOR);
    	    w.append(FILE_HEADER);
    	    w.append(NEW_LINE_SEPERATOR);
    	    for (int i=0; i < a.getQuizScore().size(); i++) {
    	        w.append(String.valueOf(i+1));
    	        w.append(COMMA_DELIMITER);
    	        w.append(String.valueOf(a.getQuizScore().get(i)));
    	        w.append(COMMA_DELIMITER);
    	        w.append(String.valueOf(a.getTimeTaken().get(i)));
    	        w.append(COMMA_DELIMITER);
    	        w.append(String.valueOf(a.getSkippedQuestions().get(i)));
    	        w.append(NEW_LINE_SEPERATOR);
    	    }
      }
      w.close();
      AlertBox.noDetails("Download Complete!");
    } catch(IOException e) {
      e.printStackTrace();
    }

  }
}
