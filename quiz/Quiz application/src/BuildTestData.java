import java.util.List;

public class BuildTestData {
	public static void testDataCreator(List<QuizQuestionPOJO> listofQuizQuestions) {
		for (int i = 0; i<=9; i++) {
		QuizQuestionPOJO quizQuestionPOJO = new QuizQuestionPOJO();
		quizQuestionPOJO.setQuestionTopic("Question");
		quizQuestionPOJO.setQuestion("Question");
		quizQuestionPOJO.setAnswerA("Answer A");
		quizQuestionPOJO.setAnswerB("Answer B");
		quizQuestionPOJO.setAnswerC("Answer C");
		quizQuestionPOJO.setCorrectAnswer("Correct Answer");
		listofQuizQuestions.add(quizQuestionPOJO);	
		}
	}
}
