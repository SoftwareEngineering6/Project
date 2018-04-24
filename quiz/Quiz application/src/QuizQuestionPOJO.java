import javafx.scene.image.ImageView;

public class QuizQuestionPOJO {
	
	String textOrImage;
	String questionTopic;
	String question;
	String answerA;
	String answerB;
	String answerC;
	String correctAnswer;
	ImageView answerAImage;
	ImageView answerBImage;
	ImageView answerCImage;
	ImageView correctImage;

	
	public String getQuestionTopic() {
		return questionTopic;
	}
	public void setQuestionTopic(String questionTopic) {
		this.questionTopic = questionTopic;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public ImageView getAnswerAImage() {
		return answerAImage;
	}
	public void setAnswerAImage(ImageView answerAImage) {
		this.answerAImage = answerAImage;
	}
	public ImageView getAnswerBImage() {
		return answerBImage;
	}
	public void setAnswerBImage(ImageView answerBImage) {
		this.answerBImage = answerBImage;
	}
	public ImageView getAnswerCImage() {
		return answerCImage;
	}
	public void setAnswerCImage(ImageView answerCImage) {
		this.answerCImage = answerCImage;
	}
	public ImageView getcorrectImage() {
		return correctImage;
	}
	public void setcorrectImage(ImageView answerDImage) {
		this.correctImage = answerDImage;
	}
	public String getTextOrImage() {
		return textOrImage;
	}
	public void setTextOrImage(String textOrImage) {
		this.textOrImage = textOrImage;
	}
}
