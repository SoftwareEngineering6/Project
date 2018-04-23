import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.*;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.event.*; 

public class PlayQuiz {
	
	static int correctAnswers = 0;
	static int skippedAnswers = 0;
	
	static int questionNumber = 0;
	static Label question = new Label();
	static Button btn1 = new Button("");
	static Button btn2 = new Button("");
	static Button btn3 = new Button("");
	static Button btn4 = new Button("");
	static Stage window = new Stage();

	public static void display(){

		FlowPane rootNode = new FlowPane(10, 10);
		Scene scene = new Scene(rootNode, 500, 500);

	    	question.setText("Question");
	    	question.setStyle("-fx-font: 28 arial;");
	    	question.setLayoutY(50);
	    	question.setLayoutX(115);

	    btn1.setLayoutY(120);
	    btn1.setLayoutX(10);
	    btn1.setPadding(new Insets(20));
   	 	btn1.setPrefWidth(200);

	    btn2.setLayoutY(120);
	    btn2.setLayoutX(220);
	    btn2.setPadding(new Insets(20));
   	 	btn2.setPrefWidth(200);

	    btn3.setLayoutY(200);
	    btn3.setLayoutX(10);
	    btn3.setPadding(new Insets(20));
   	 	btn3.setPrefWidth(200);

	    btn4.setLayoutY(200);
	    btn4.setLayoutX(220);
	    btn4.setPadding(new Insets(20));
   	 	btn4.setPrefWidth(200);

   	 	Button btn5 = new Button("Reset");
   	 	btn5.setOnAction(e -> {
   	 		questionNumber = 0;		//Resets quiz for next user
   	 		window.close();
   	 	});
	    btn5.setLayoutY(390);
	    btn5.setLayoutX(10);
	    btn5.setPadding(new Insets(10));
   	 	btn5.setPrefWidth(80);

   	 	Button btn6 = new Button("Skip");
   	 	btn6.setOnAction(e -> {
   	 		skippedAnswers++;
   	 		alertBox.quizAnswerMessage("Skipped!", "Question skipped");
   	 	});
	    btn6.setLayoutY(390);
	    btn6.setLayoutX(390);
	    btn6.setPadding(new Insets(10));
   	 	btn6.setPrefWidth(80);

	    Pane root = new Pane();
		root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
		
		randomiser(question, AddQuestionSet.listofQuizQuestions.get(questionNumber), btn1, btn2, btn3, btn4);

		btn1.setOnAction(e -> {
			if(btn1.getText().equals(AddQuestionSet.listofQuizQuestions.get(questionNumber).correctAnswer)) {
				correctAnswers++;
				alertBox.quizAnswerMessage("Correct!", "Correct answer, Well done!");
			} else {
				alertBox.quizAnswerMessage("Wrong!", "Wrong answer!");	
			}
		});
		
		btn2.setOnAction(e -> {
			if(btn2.getText().equals(AddQuestionSet.listofQuizQuestions.get(questionNumber).correctAnswer)) {
				correctAnswers++;
				alertBox.quizAnswerMessage("Correct!", "Correct answer, Well done!");
			} else {
				alertBox.quizAnswerMessage("Wrong!", "Wrong answer!");	
			}
		});
		
		btn3.setOnAction(e -> {
			if(btn3.getText().equals(AddQuestionSet.listofQuizQuestions.get(questionNumber).correctAnswer)) {
				correctAnswers++;
				alertBox.quizAnswerMessage("Correct!", "Correct answer, Well done!");
			} else {
				alertBox.quizAnswerMessage("Wrong!", "Wrong answer!");	
			}
		});
		
		btn4.setOnAction(e -> {
			if(btn4.getText().equals(AddQuestionSet.listofQuizQuestions.get(questionNumber).correctAnswer)) {
				correctAnswers++;
				alertBox.quizAnswerMessage("Correct!", "Correct answer, Well done!");
			} else {
				alertBox.quizAnswerMessage("Wrong!", "Wrong answer!");	
			}
		});
		
		rootNode.getChildren().addAll(question, root);
        window.setScene(scene);
		window.show();
	}
	
	public static void randomiser(Label question, QuizQuestionPOJO a, Button btn1, 
			Button btn2, Button btn3, Button btn4) {
		
		question.setText(AddQuestionSet.listofQuizQuestions.get(questionNumber).question);
	    Random rand = new Random();
	    List<String> questionList = new ArrayList();
	    List<Button> buttonList = new ArrayList();
	    questionList.add(a.getAnswerA());
	    questionList.add(a.getAnswerB());
	    questionList.add(a.getAnswerC());
	    questionList.add(a.getCorrectAnswer());
	    buttonList.add(btn1);
	    buttonList.add(btn2);
	    buttonList.add(btn3);
	    buttonList.add(btn4);

	    int numberOfElements = 4;
	 
	    for (int i = 0; i < numberOfElements; i++) {
	        int randomQIndex = rand.nextInt(questionList.size());
	        int randomBIndex = rand.nextInt(buttonList.size());

	        String randomElement = questionList.get(randomQIndex);
	        buttonList.get(randomBIndex).setText(randomElement);
	        questionList.remove(randomQIndex);
	        buttonList.remove(randomBIndex);
	    }
	}
}



