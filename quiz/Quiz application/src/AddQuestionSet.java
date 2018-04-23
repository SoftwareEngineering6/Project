import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddQuestionSet {
	static List<QuizQuestionPOJO> listofQuizQuestions = new ArrayList<QuizQuestionPOJO>();
	static int counter = 0;
	static Stage window = new Stage();
	
	public static List<QuizQuestionPOJO> display() {
		
		
		
	ImageView answerAImg = new ImageView();
	ImageView answerBImg = new ImageView();
	ImageView answerCImg = new ImageView();
	ImageView answerDImg = new ImageView();
	BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 500, 500, Color.WHITE);

    GridPane gridpane = new GridPane();
    gridpane.setPadding(new Insets(5));
    gridpane.setHgap(5);
    gridpane.setVgap(5);
    ColumnConstraints column1 = new ColumnConstraints(150);
    ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
    column2.setHgrow(Priority.ALWAYS);
    gridpane.getColumnConstraints().addAll(column1, column2);

    Label questionTopic = new Label("Enter question topic");
    Label actualQuestion = new Label("Enter the question");
    Label answerA = new Label("Answer A");
    Label answerB = new Label("Answer B");
    Label answerC = new Label("Answer C");
    Label correctAnswer = new Label("Correct Answer");

    TextField questionTopicField = new TextField();
    TextField actualQuestionField = new TextField();
    TextField answerAField = new TextField();
    TextField answerBField = new TextField();
    TextField answerCField = new TextField();
    TextField correctAnswerField = new TextField();
    questionTopicField.setPadding(new Insets(10));
    actualQuestionField.setPadding(new Insets(10));
    answerAField.setPadding(new Insets(10));
    answerBField.setPadding(new Insets(10));
    answerCField.setPadding(new Insets(10));
    correctAnswerField.setPadding(new Insets(10));
    
    Button answerAImageButton = new Button();
    answerAImageButton.setOnAction(e-> {
    		imageButtonAction(answerAImg);
    });
    Button answerBImageButton = new Button();
    answerBImageButton.setOnAction(e-> {
    		imageButtonAction(answerBImg);
    });
    Button answerCImageButton = new Button();
    answerCImageButton.setOnAction(e-> {
    		imageButtonAction(answerCImg);
    });
    Button answerDImageButton = new Button();
    answerDImageButton.setOnAction(e-> {
    		imageButtonAction(answerDImg);
    });
    
    Button returnButt = new Button("Return");
    returnButt.setStyle("-fx-font: 16 arial;");
    returnButt.setOnAction(e -> window.close());
    
    Button saveButt = new Button("Save");
    saveButt.setStyle("-fx-font: 16 arial;");
    saveButt.setOnAction(e ->{
    		if(answerAField.getText().isEmpty() || answerBField.getText().isEmpty() 
    				|| answerCField.getText().isEmpty() || correctAnswerField.getText().isEmpty()
    				|| questionTopicField.getText().isEmpty() || actualQuestionField.getText().isEmpty()) {
    			alertBox.noDetails("Incomplete", "Please enter all details");
    		} else if(counter != 9) {
			QuizQuestionPOJO quizQuestionPOJO = new QuizQuestionPOJO();
    			quizQuestionPOJO.setQuestionTopic(questionTopicField.getText());
    			quizQuestionPOJO.setQuestion(actualQuestionField.getText());
    			quizQuestionPOJO.setAnswerA(answerAField.getText());
    			quizQuestionPOJO.setAnswerB(answerBField.getText());
    			quizQuestionPOJO.setAnswerC(answerCField.getText());
    			quizQuestionPOJO.setCorrectAnswer(correctAnswerField.getText());
    			listofQuizQuestions.add(quizQuestionPOJO);
    			actualQuestionField.clear();
    			answerAField.clear();
    			answerBField.clear();
    			answerCField.clear();
    			correctAnswerField.clear();
    			alertBox.noDetails("Successful", "Question added");
    			counter++;
			} else {
    			alertBox.noDetails("10 Added", "10 Questions added");
			}
    });
    
    // Text labels for entry fields
    GridPane.setHalignment(questionTopic, HPos.RIGHT);
    gridpane.add(questionTopic, 0, 0);
    GridPane.setHalignment(actualQuestion, HPos.RIGHT);
    gridpane.add(actualQuestion, 0, 1);
    GridPane.setHalignment(answerA, HPos.RIGHT);
    gridpane.add(answerA, 0, 2);
    GridPane.setHalignment(answerB, HPos.RIGHT);
    gridpane.add(answerB, 0, 3);
    GridPane.setHalignment(answerC, HPos.RIGHT);
    gridpane.add(answerC, 0, 4);
    GridPane.setHalignment(correctAnswer, HPos.RIGHT);
    gridpane.add(correctAnswer, 0, 5);

    // Text entry fields
    GridPane.setHalignment(questionTopicField, HPos.LEFT);
    gridpane.add(questionTopicField, 1, 0);
    GridPane.setHalignment(actualQuestionField, HPos.LEFT);
    gridpane.add(actualQuestionField, 1, 1);
    GridPane.setHalignment(answerAField, HPos.LEFT);
    gridpane.add(answerAField, 1, 2);
    GridPane.setHalignment(answerBField, HPos.LEFT);
    gridpane.add(answerBField, 1, 3);
    GridPane.setHalignment(answerCField, HPos.LEFT);
    gridpane.add(answerCField, 1, 4);
    GridPane.setHalignment(correctAnswerField, HPos.LEFT);
    gridpane.add(correctAnswerField, 1, 5);

    // Save button
    GridPane.setHalignment(saveButt, HPos.RIGHT);
    gridpane.add(saveButt, 1, 6);
    GridPane.setHalignment(returnButt, HPos.RIGHT);
    gridpane.add(returnButt, 0, 6);
    
    
    HBox titleBox = new HBox();
	Label titleLabel = new Label("Add Questions");
	titleBox.setAlignment(Pos.CENTER);
	titleBox.getChildren().add(titleLabel);
	
	HBox questionsetterBox = new HBox();
	questionsetterBox.setAlignment(Pos.CENTER);
	GridPane questionGrid = new GridPane();
    GridPane.setHalignment(actualQuestion, HPos.RIGHT);
    questionGrid.add(actualQuestion, 0, 0);
    GridPane.setHalignment(actualQuestionField, HPos.LEFT);
    questionGrid.add(actualQuestionField, 1, 0);
	questionsetterBox.getChildren().add(questionGrid);
	
	TabPane tabpane = new TabPane();
	Tab tab1 = new Tab();
	Tab tab2 = new Tab();
	tabpane.getTabs().addAll(tab1,tab2);

    root.setCenter(gridpane);
    window.setScene(scene);
    window.show();
	return listofQuizQuestions;
  }
	
	public static void imageButtonAction(ImageView iv) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Add image");		
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File file = fileChooser.showOpenDialog(window);
        Image image = new Image(file.toURI().toString());
        iv.setImage(image);
        iv.setFitWidth(100);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
	}
}

