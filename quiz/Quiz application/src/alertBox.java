import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class alertBox {
	public static void noDetails(String title, String message) {
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); // prevents user interacting with page behind alert box
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label1 = new Label();
		label1.setText(message);
		Button closeButton = new Button("Return");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label1, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	} 
	
	public static void quizAnswerMessage(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); // prevents user interacting with page behind alert box
		window.setTitle(title);
		window.setMinWidth(250);
		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		
		Label label1 = new Label();
		Label label2 = new Label();
		Button closeButton = new Button("Return");
		
		if(PlayQuiz.questionNumber==9) {
			label1.setText(message);
			label2.setText("You have finished the quiz");
			layout.getChildren().addAll(label1,label2);
			PlayQuiz.questionNumber = 0;	// reset for next user
			// add bit for score
		} else {
			label1.setText(message);
			closeButton.setOnAction(e -> {
				PlayQuiz.questionNumber++;
				window.close();
				PlayQuiz.randomiser(PlayQuiz.question, AddQuestionSet.listofQuizQuestions.get
						(PlayQuiz.questionNumber), PlayQuiz.btn1, PlayQuiz.btn2, PlayQuiz.btn3, PlayQuiz.btn4);
			});
			layout.getChildren().addAll(label1, closeButton);
		}
				
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();	
	}
}
