import java.io.*;

public class WriteToCsv {
  public static void download(File file) {

    final String COMMA_DELIMITER = ",";
    final String NEW_LINE_SEPERATOR = "\n";
    final String FILE_HEADER = "Student,Score,Time taken,Skipped";
    final String FILE_HEADER1 = "Average Score,Average Time taken,Average skipped";
	String sep = System.getProperty("file.separator");	// For different file systems

    try {
      Writer w = new FileWriter(new File(file.getAbsolutePath()) + ".csv");

      for(School a : Main.choiceBox.getItems()) {
    	  	w.append(String.valueOf(a.schoolName));
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
    	    w.append(FILE_HEADER1);
    	    w.append(NEW_LINE_SEPERATOR);
	    w.append(String.valueOf(getAverageScore(a)));
	    w.append(COMMA_DELIMITER);
	    w.append(String.valueOf(getAverageTime(a)));
	    w.append(COMMA_DELIMITER);
	    w.append(String.valueOf(getAverageSkipped(a)));
	    w.append(COMMA_DELIMITER);
        w.append(NEW_LINE_SEPERATOR);
        w.append(NEW_LINE_SEPERATOR);
      }
      w.close();
    } catch(IOException e) {
      e.printStackTrace();
    }

  }
  public static int getAverageScore(School a) {
	  int average = 0;
	  for (int x: a.getQuizScore()) {
		  average += x; 
	  }
	  average = average/a.getQuizScore().size();
	  return average;
  }
  
  public static int getAverageSkipped(School a) {
	  int skipped = 0;
	  for (int x: a.getSkippedQuestions()) {
		  skipped += x; 
	  }
	  return skipped;
  }
  
  public static double getAverageTime(School a) {
	  double average = 0.;
	  for (double x: a.getTimeTaken()) {
		  average += x; 
	  }
	  average = average/a.getTimeTaken().size();
	  return average;
  }
}
