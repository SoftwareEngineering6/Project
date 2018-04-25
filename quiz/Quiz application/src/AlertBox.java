import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class AlertBox {
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
	
	public static void deleteQuestions() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); // prevents user interacting with page behind alert box
		window.setMinWidth(250);
		
		Label label1 = new Label();
		label1.setText("Are you sure?");
		label1.setStyle("-fx-text-fill:#DAFFEF; -fx-font-size:16");
		Button closeButton = new Button("Cancel");
		Button deleteButton = new Button("Delete");
		deleteButton.getStyleClass().add("navigation-buttons");
		closeButton.getStyleClass().add("navigation-buttons");
		closeButton.setOnAction(e -> window.close());
		deleteButton.setOnAction(e -> {
			AddQuestionSet.listofQuizQuestions.clear();
			window.close();
			noDetails("Question set deleted");
		});
		
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(closeButton,AddQuestionSet.createSpacer(),deleteButton);
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label1, hbox);
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
	
	public static void passwordAccess() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); // prevents user interacting with page behind alert box
		window.setMinWidth(250);
		
		Label label1 = new Label("Enter Password:");
		PasswordField pBox = new PasswordField();
		pBox.setStyle("-fx-background-color: #DAFFEF; -fx-font-size: 14; -fx-text-fill: #39393A; -fx-cursor: hand");
		label1.setStyle("-fx-text-fill:#DAFFEF; -fx-font-size:16");
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(20));
        gridpane.add(label1, 0, 0);
        GridPane.setHalignment(label1, HPos.RIGHT);
        gridpane.add(pBox, 1, 0);
        GridPane.setHalignment(pBox, HPos.LEFT);
        gridpane.setHgap(10);
		
		Button closeButton = new Button("Return");
		Button enterPassword = new Button("Confirm");
		enterPassword.getStyleClass().add("navigation-buttons");
		closeButton.getStyleClass().add("navigation-buttons");
		closeButton.setOnAction(e -> window.close());
		enterPassword.setOnAction(e ->{
			if(pBox.getText().isEmpty()) {
				noDetails("Enter a password");
			} else if(pBox.getText().contentEquals("password")) {
				Main.engagement();
				window.close();
			} else {
				noDetails("Password incorrect");
			}
		});
		
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(closeButton, AddQuestionSet.createSpacer(), enterPassword);
		
		BorderPane borderpane = new BorderPane();
		borderpane.getStyleClass().add("alertbox-background");
		borderpane.setPadding(new Insets(20));
		borderpane.setCenter(gridpane);
		borderpane.setBottom(hbox);
		Scene scene = new Scene(borderpane);
		scene.getStylesheets().add("NewFile.css");
		window.setScene(scene);
		window.showAndWait();	
	}
}
