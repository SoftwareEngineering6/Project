import java.util.ArrayList;
import java.util.List;

public class school {
	String schoolName;
	int studentAges; 
	List<Double> timeTaken = new ArrayList<Double>();
	List<Integer> quizScore = new ArrayList<Integer>();
	List<Integer> skippedQuestions = new ArrayList<Integer>();
	int numberOfPlayers = quizScore.size();	// Will show how many people have taken quiz from school
	
	public school(String schoolName, int studentAges) {
		this.schoolName = schoolName;
		this.studentAges = studentAges;
	}
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getStudentAges() {
		return studentAges;
	}

	public void setStudentAges(int studentAges) {
		this.studentAges = studentAges;
	}

	public List<Double> getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Double timeTaken) {
		this.timeTaken.add(timeTaken);
	}

	public List<Integer> getQuizScore() {
		return quizScore;
	}

	public void setQuizScore(Integer quizScore) {
		this.quizScore.add(quizScore);
	}

	public List<Integer> getSkippedQuestions() {
		return skippedQuestions;
	}

	public void setSkippedQuestions(Integer skippedQuestions) {
		this.skippedQuestions.add(skippedQuestions);
	}
}
