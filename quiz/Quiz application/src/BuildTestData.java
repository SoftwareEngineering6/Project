import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BuildTestData {
	static Image image1 = new Image("image1.jpg");
	static Image image2 = new Image("image2.jpg");
	static Image image3 = new Image("image3.jpg");
	static Image image4 = new Image("correctImage.jpg");
	/* all images from Flickr under CC license */

	static ImageView iv1 = new ImageView();
	static ImageView iv2 = new ImageView();
	static ImageView iv3 = new ImageView();
	static ImageView iv4 = new ImageView();


	public static void testDataCreator(List<QuizQuestionPOJO> listofQuizQuestions) {
		iv1.setImage(image1);
		iv2.setImage(image2);
		iv3.setImage(image3);
		iv4.setImage(image4);
		for (int i = 0; i<10; i++) {
			if (i==0 || i == 5 || i == 7) {
				iv1.setFitWidth(250);
	            iv1.setPreserveRatio(true);
	            iv1.setSmooth(true);
	            iv1.setCache(true);
				iv2.setFitWidth(250);
	            iv2.setPreserveRatio(true);
	            iv2.setSmooth(true);
	            iv2.setCache(true);
				iv3.setFitWidth(250);
	            iv3.setPreserveRatio(true);
	            iv3.setSmooth(true);
	            iv3.setCache(true);
				iv4.setFitWidth(250);
	            iv4.setPreserveRatio(true);
	            iv4.setSmooth(true);
	            iv4.setCache(true);
				QuizQuestionPOJO quizQuestionPOJO = new QuizQuestionPOJO();
				quizQuestionPOJO.setTextOrImage("Image");
				quizQuestionPOJO.setQuestionTopic("Question");
				quizQuestionPOJO.setQuestion("Which of these is the Eiffel Tower");
				quizQuestionPOJO.setAnswerAImage(iv1);
				quizQuestionPOJO.setAnswerBImage(iv2);
				quizQuestionPOJO.setAnswerCImage(iv3);
				quizQuestionPOJO.setcorrectImage(iv4);
				listofQuizQuestions.add(quizQuestionPOJO);
			} else {
			QuizQuestionPOJO quizQuestionPOJO = new QuizQuestionPOJO();
			quizQuestionPOJO.setTextOrImage("Text");
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
}
