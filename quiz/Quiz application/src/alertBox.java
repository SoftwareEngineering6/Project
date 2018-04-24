import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class alertBox {
	public static void noDetails(String message) {
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); // prevents user interacting with page behind alert box
		window.setMinWidth(250);
		
		Label label1 = new Label();
		label1.setText(message);
		label1.setStyle("-fx-text-fill:#DAFFEF; -fx-font-size:16");
		Button closeButton = new Button("Return");
		closeButton.getStyleClass().add("navigation-buttons");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label1, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		BorderPane borderpane = new BorderPane();
		borderpane.getStyleClass().add("alertbox-background");
		borderpane.setPadding(new Insets(20));
		borderpane.setCenter(layout);
		Scene scene = new Scene(borderpane);
		scene.getStylesheets().add("NewFile.css");
		window.setScene(scene);
		window.showAndWait();
	} 
	
	public static void quizAnswerMessage(String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); // prevents user interacting with page behind alert box
		window.setMinWidth(500);
		window.setMinHeight(300);
		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		
		Label label1 = new Label();
		label1.setStyle("-fx-text-fill:#DAFFEF; -fx-font-size:20");
		Label label2 = new Label();
		label2.setStyle("-fx-text-fill:#DAFFEF; -fx-font-size:20");
		Button closeButton = new Button("Return");
		closeButton.getStyleClass().add("navigation-buttons");
		
		if(PlayQuiz.questionNumber==9) {
			Stopwatch.playerElapsedTime = Stopwatch.elapsedTime();	// records how long player took on the quiz
			label1.setStyle("-fx-text-fill:#DAFFEF; -fx-font-size: 30");
			if(PlayQuiz.correctAnswers == 10) {
				label1.setText("Perfect Score");
				label2.setText("You scored " + PlayQuiz.correctAnswers + " out of 10!");
			} else if (PlayQuiz.correctAnswers < 10 && PlayQuiz.correctAnswers > 5) {
				label1.setText("Congratulations");
				label2.setText("You scored " + PlayQuiz.correctAnswers + " out of 10!");
			} else {
				label1.setText("Keep trying");
				label2.setText("You scored " + PlayQuiz.correctAnswers + " out of 10!");
			}
			closeButton.setText("End Quiz");
			layout.getChildren().addAll(label1,label2,closeButton);
			Main.choiceBox.getSelectionModel().getSelectedItem().setQuizScore(PlayQuiz.correctAnswers);
			System.out.println(Main.choiceBox.getSelectionModel().getSelectedItem().getQuizScore());
			Main.choiceBox.getSelectionModel().getSelectedItem().setTimeTaken(Stopwatch.playerElapsedTime);
			Main.choiceBox.getSelectionModel().getSelectedItem().setSkippedQuestions(PlayQuiz.skippedAnswers);
			PlayQuiz.questionNumber = 0;	// reset for next user
			PlayQuiz.correctAnswers = 0;
   	 		PlayQuiz.skippedAnswers = 0;

			// Above code adds data for school into array lists
			closeButton.setOnAction(e -> {
				window.close();
				PlayQuiz.window.close();
			});
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
		
		BorderPane borderpane = new BorderPane();
		borderpane.getStyleClass().add("alertbox-background");
		borderpane.setPadding(new Insets(20));
		borderpane.setCenter(layout);
		Scene scene = new Scene(borderpane);
		scene.getStylesheets().add("NewFile.css");
		window.setScene(scene);
		window.showAndWait();	
	}
}
