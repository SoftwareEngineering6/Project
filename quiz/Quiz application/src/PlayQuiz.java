import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.geometry.*;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayQuiz {
	
	static int correctAnswers = 0;
	static int skippedAnswers = 0;
	static int questionNumber = 0;
	static boolean hasQuizbeenPlayed = false;
	
	static Label question = new Label();
	static Button btn1 = new Button("");
	static Button btn2 = new Button("");
	static Button btn3 = new Button("");
	static Button btn4 = new Button("");
	static Stage window = new Stage();

	public static void display(){
	
	    	question.setText("");
	    	question.setId("page-titles");

   	 	Button btn5 = new Button("Reset");
   	 	btn5.getStyleClass().add("navigation-buttons");
   	 	btn5.setOnAction(e -> {
   	 		questionNumber = 0;		//Resets quiz for next user
   	 		correctAnswers = 0;
   	 		skippedAnswers = 0;
   	 		AlertBox.quizAnswerMessage("Quiz reset");
   	 		window.close();
   	 	});

   	 	Button btn6 = new Button("Skip");
   	 	btn6.getStyleClass().add("navigation-buttons");
   	 	btn6.setOnAction(e -> {
   	 		skippedAnswers++;
   	 		AlertBox.quizAnswerMessage("Question skipped!");
   	 	});
		
		randomiser(question, AddQuestionSet.listofQuizQuestions.get(questionNumber), btn1, btn2, btn3, btn4);
		
		HBox questionTopBar = new HBox();
		questionTopBar.setAlignment(Pos.CENTER);
		questionTopBar.getChildren().add(question);
		
		GridPane questionGridArea = new GridPane();
		questionGridArea.setAlignment(Pos.CENTER);
	    GridPane.setHalignment(btn1, HPos.CENTER);
		questionGridArea.add(btn1, 0, 0);
	    GridPane.setHalignment(btn2, HPos.CENTER);
		questionGridArea.add(btn2, 0, 1);
	    GridPane.setHalignment(btn3, HPos.CENTER);
		questionGridArea.add(btn3, 1, 0);
	    GridPane.setHalignment(btn4, HPos.CENTER);
		questionGridArea.add(btn4, 1, 1);
		questionGridArea.setPadding(new Insets(30));
		questionGridArea.setHgap(100);
		questionGridArea.setVgap(100);
		for(int x=0;x<2;x++) {
			ColumnConstraints c1 = new ColumnConstraints();
			c1.setPercentWidth(50);
			questionGridArea.getColumnConstraints().add(c1);
		}
		
		HBox optionBottomBar = new HBox();
		optionBottomBar.setAlignment(Pos.CENTER);
		optionBottomBar.getChildren().addAll(btn5,AddQuestionSet.createSpacer(),btn6);
		
		BorderPane borderpane = new BorderPane();
		borderpane.getStyleClass().add("playquiz-borderpane");
		borderpane.setPadding(new Insets(20));
		borderpane.setTop(questionTopBar);
		borderpane.setCenter(questionGridArea);
		borderpane.setBottom(optionBottomBar);
		
		Scene scene = new Scene(borderpane, 900, 700);
		scene.getStylesheets().add("NewFile.css");
        window.setScene(scene);
		window.show();
	}
	
	
	/* Everything is in here otherwise NullPointerExeption occurs, method will check if it is text or image
	 question, then assign the answers to the buttons, and deal with the reset after each question */
	public static void randomiser(Label question, QuizQuestionPOJO a, Button btn1, 
			Button btn2, Button btn3, Button btn4) {
		btn1.setText("");
		btn2.setText("");
		btn3.setText("");
		btn4.setText("");
		btn1.setGraphic(null);
		btn2.setGraphic(null);
		btn3.setGraphic(null);
		btn4.setGraphic(null);
		
		question.setText(AddQuestionSet.listofQuizQuestions.get(questionNumber).question);
	    Random rand = new Random();
	    List<String> questionListText = new ArrayList<String>();
	    List<ImageView> questionListImage = new ArrayList<ImageView>();
	    List<Button> buttonList = new ArrayList<Button>();
	    
	    try {
		    	if(a.getTextOrImage().contains("Image")) {
		    		questionListImage.add(a.getAnswerAImage());
		    		questionListImage.add(a.getAnswerBImage());
		    		questionListImage.add(a.getAnswerCImage());
		    		questionListImage.add(a.getcorrectImage());
		    	    buttonList.add(btn1);
		    	    buttonList.add(btn2);
		    	    buttonList.add(btn3);
		    	    buttonList.add(btn4);
		    	    int numberOfElements = 4;
		    	    for (int i = 0; i < numberOfElements; i++) {
		    	        int randomQIndex = rand.nextInt(questionListImage.size());
		    	        int randomBIndex = rand.nextInt(buttonList.size());
		    	        ImageView randomElement = questionListImage.get(randomQIndex);   
		    	        buttonList.get(randomBIndex).setGraphic(randomElement);
		    	        buttonList.get(randomBIndex).setStyle("-fx-background-color: transparent; -fx-cursor: hand");
		    	        questionListImage.remove(randomQIndex);
		    	        buttonList.remove(randomBIndex);
		    	    }
		    	    
		    	    btn1.setOnAction(e -> imageQuestionChecker(btn1));
		    	    btn2.setOnAction(e -> imageQuestionChecker(btn2));
		    		btn3.setOnAction(e -> imageQuestionChecker(btn3));
		    		btn4.setOnAction(e -> imageQuestionChecker(btn4));
		    		
		    } else if (a.getTextOrImage().contains("Text")) {
			    questionListText.add(a.getAnswerA());
			    questionListText.add(a.getAnswerB());
			    questionListText.add(a.getAnswerC());
			    questionListText.add(a.getCorrectAnswer());
			    buttonList.add(btn1);
			    buttonList.add(btn2);
			    buttonList.add(btn3);
			    buttonList.add(btn4);	
			    int numberOfElements = 4;
				 
			    for (int i = 0; i < numberOfElements; i++) {
			        int randomQIndex = rand.nextInt(questionListText.size());
			        int randomBIndex = rand.nextInt(buttonList.size());
			        String randomElement = questionListText.get(randomQIndex);
			        buttonList.get(randomBIndex).setWrapText(true);
			        buttonList.get(randomBIndex).setText(randomElement);
			        buttonList.get(randomBIndex).setStyle("	-fx-background-radius: 20;\n" + 
			        		"	-fx-min-width: 200;\n" + 
			        		"	-fx-min-height: 100;\n" + 
			        		"	-fx-background-color: #DAFFEF;\n" + 
			        		"	-fx-text-fill: #39393A;\n" + 
			        		"	-fx-cursor: hand ;\n" +
			        		"	-fx-font-size: 18;");
			        questionListText.remove(randomQIndex);
			        buttonList.remove(randomBIndex);
			    }
			    
			    btn1.setOnAction(e -> textQuestionChecker(btn1));
			    btn2.setOnAction(e -> textQuestionChecker(btn2));
				btn3.setOnAction(e -> textQuestionChecker(btn3));
				btn4.setOnAction(e -> textQuestionChecker(btn4));
				
		    }
	    } catch (NullPointerException e) {
            e.printStackTrace();
	    }
	}
    
    public static void textQuestionChecker(Button button) {
    		if(button.getText().equals(AddQuestionSet.listofQuizQuestions.get(questionNumber).correctAnswer)) {
			correctAnswers++;
			AlertBox.quizAnswerMessage("Correct answer, Well done!");
		} else {
			AlertBox.quizAnswerMessage("Wrong answer!");	
		}
    }
    
    public static void imageQuestionChecker(Button button) {
    		if(button.getGraphic().equals(AddQuestionSet.listofQuizQuestions.get(questionNumber).correctImage)) {
			correctAnswers++;
			AlertBox.quizAnswerMessage("Correct answer, Well done!");
		} else {
			AlertBox.quizAnswerMessage("Wrong answer!");	
		}
    }
}



