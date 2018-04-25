import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddQuestionSet {
	static List<QuizQuestionPOJO> listofQuizQuestions = new ArrayList<QuizQuestionPOJO>();
	static int counter = 0;
	static Stage window = new Stage();
	
	public static void display() {
		ImageView[] imageList = new ImageView[4];
		imageList[0] = new ImageView();
		imageList[1] = new ImageView();
		imageList[2] = new ImageView();
		imageList[3] = new ImageView();
		for(ImageView a:imageList) {
			a.setFitWidth(200);
			a.setPreserveRatio(true);
			a.setSmooth(true);
			a.setCache(true);
		}
		
	    Label actualQuestion = new Label("Enter the question:");
	    Label answerATextLabel = new Label("Answer A:");
	    Label answerBTextLabel = new Label("Answer B:");
	    Label answerCTextLabel = new Label("Answer C:");
	    Label correctAnswerTextLabel = new Label("Correct Answer:");
	    
	    Label answerAImageLabel = new Label("Answer A:");
	    Label answerBImageLabel = new Label("Answer B:");
	    Label answerCImageLabel = new Label("Answer C:");
	    Label correctAnswerImageLabel = new Label("Correct Answer:");
	
	    TextField actualQuestionField = new TextField();
	    TextField answerAField = new TextField();
	    TextField answerBField = new TextField();
	    TextField answerCField = new TextField();
	    TextField correctAnswerField = new TextField();
	    
	    Button answerAImageButton = new Button("Add image");
	    answerAImageButton.getStyleClass().add("image-adder-button");
	    answerAImageButton.setOnAction(e-> {
	    		imageButtonAction(imageList[0],answerAImageButton);
	    });
	    Button answerBImageButton = new Button("Add image");
	    answerBImageButton.getStyleClass().add("image-adder-button");
	    answerBImageButton.setOnAction(e-> {
	    		imageButtonAction(imageList[1],answerBImageButton);
	    });
	    Button answerCImageButton = new Button("Add image");
	    answerCImageButton.getStyleClass().add("image-adder-button");
	    answerCImageButton.setOnAction(e-> {
	    		imageButtonAction(imageList[2],answerCImageButton);
	    });
	    Button correctAnswerImageButton = new Button("Add image");
	    correctAnswerImageButton.getStyleClass().add("image-adder-button");
	    correctAnswerImageButton.setOnAction(e-> {
	    		imageButtonAction(imageList[3],correctAnswerImageButton);
	    });
	    
	    Button returnButtText = new Button("Cancel");
	    returnButtText.getStyleClass().add("navigation-buttons");
	    Button returnButtImage = new Button("Cancel");
	    returnButtImage.getStyleClass().add("navigation-buttons");
	    returnButtText.setOnAction(e -> window.close());
	    returnButtImage.setOnAction(e -> window.close());
	    
	    Button saveButtText = new Button("Save");
	    saveButtText.getStyleClass().add("navigation-buttons");
	    Button saveButtImage = new Button("Save");
	    saveButtImage.getStyleClass().add("navigation-buttons");
	
	    saveButtText.setOnAction(e ->{
	    		if(answerAField.getText().isEmpty() || answerBField.getText().isEmpty() 
	    				|| answerCField.getText().isEmpty() || correctAnswerField.getText().isEmpty()
	    				|| actualQuestionField.getText().isEmpty()) {
	    			AlertBox.noDetails( "Please enter all details");
	    		} else if(counter != 9) {
	    			createTextQuestion(actualQuestionField, answerAField, answerBField, answerCField, correctAnswerField);
	    			AlertBox.noDetails("Text question added");
	    			counter++;
			} else {
				createTextQuestion(actualQuestionField, answerAField, answerBField, answerCField, correctAnswerField);
	    			AlertBox.noDetails("10 Questions added");
	    			window.close();
				}
	    });
	    
	    saveButtImage.setOnAction(e ->{
			if(imageList[0].getImage() == null || imageList[1].getImage() == null || imageList[2].getImage() == null
					|| imageList[3].getImage() == null ||actualQuestionField.getText().isEmpty()) {
				AlertBox.noDetails("Please add all images");
			} else if(counter != 9) {
				createImageQuestion(actualQuestionField, imageList[0], imageList[1], imageList[2], imageList[3]);
				AlertBox.noDetails("Image question added");
				counter++;
			} else {
				createImageQuestion(actualQuestionField, imageList[0], imageList[1], imageList[2], imageList[3]);
				AlertBox.noDetails("10 Questions added");
				window.close();
			}
	    });
	
	    HBox titleBox = new HBox();
		Label titleLabel = new Label("Add Questions");
		titleLabel.setId("page-titles");
		titleBox.setAlignment(Pos.CENTER);
		titleBox.getChildren().add(titleLabel);
		
		HBox questionSetterBox = new HBox();
		questionSetterBox.setAlignment(Pos.CENTER);
		GridPane questionGrid = new GridPane();
	    GridPane.setHalignment(actualQuestion, HPos.RIGHT);
	    questionGrid.add(actualQuestion, 0, 0);
	    GridPane.setHalignment(actualQuestionField, HPos.LEFT);
	    questionGrid.add(actualQuestionField, 1, 0);
		questionSetterBox.getChildren().add(questionGrid);
	    ColumnConstraints c1 = new ColumnConstraints(150);
	    ColumnConstraints c2 = new ColumnConstraints(250);
	    questionGrid.getColumnConstraints().addAll(c1,c2);
	    questionGrid.setPadding(new Insets(30));
	    questionGrid.setHgap(20);
		
		TabPane tabpane = new TabPane();
		tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		Tab tab1 = new Tab("Add a text question");
		tab1.setOnSelectionChanged(e->{
			imageList[0].setImage(null);
			imageList[1].setImage(null);
			imageList[2].setImage(null);
			imageList[3].setImage(null);
		});
		Tab tab2 = new Tab("Add an image question");
		tab2.setOnSelectionChanged(e->{
			answerAField.clear();
			answerBField.clear();
			answerCField.clear();
			correctAnswerField.clear();
		});
		tabpane.getTabs().addAll(tab1,tab2);
		
		GridPane textQuestionGrid = new GridPane();
		GridPane.setHalignment(answerATextLabel, HPos.RIGHT);
		textQuestionGrid.add(answerATextLabel, 0, 0);
	    GridPane.setHalignment(answerBTextLabel, HPos.RIGHT);
	    textQuestionGrid.add(answerBTextLabel, 0, 1);
	    GridPane.setHalignment(answerCTextLabel, HPos.RIGHT);
	    textQuestionGrid.add(answerCTextLabel, 0, 2);
	    GridPane.setHalignment(correctAnswerTextLabel, HPos.RIGHT);
	    textQuestionGrid.add(correctAnswerTextLabel, 0, 3);
	    GridPane.setHalignment(answerAField, HPos.LEFT);
	    textQuestionGrid.add(answerAField, 1, 0);
	    GridPane.setHalignment(answerBField, HPos.LEFT);
	    textQuestionGrid.add(answerBField, 1, 1);
	    GridPane.setHalignment(answerCField, HPos.LEFT);
	    textQuestionGrid.add(answerCField, 1, 2);
	    GridPane.setHalignment(correctAnswerField, HPos.LEFT);
	    textQuestionGrid.add(correctAnswerField, 1, 3);
	    GridPane.setHalignment(saveButtText, HPos.RIGHT);
	    textQuestionGrid.add(saveButtText, 1, 4);
	    GridPane.setHalignment(returnButtText, HPos.RIGHT);
	    textQuestionGrid.add(returnButtText, 0, 4);
	    
		GridPane imageQuestionGrid = new GridPane();
		GridPane.setHalignment(answerAImageLabel, HPos.RIGHT);
		imageQuestionGrid.add(answerAImageLabel, 0, 0);
	    GridPane.setHalignment(answerBImageLabel, HPos.RIGHT);
	    imageQuestionGrid.add(answerBImageLabel, 0, 1);
	    GridPane.setHalignment(answerCImageLabel, HPos.RIGHT);
	    imageQuestionGrid.add(answerCImageLabel, 0, 2);
	    GridPane.setHalignment(correctAnswerImageLabel, HPos.RIGHT);
	    imageQuestionGrid.add(correctAnswerImageLabel, 0, 3);
	    GridPane.setHalignment(answerAImageButton, HPos.LEFT);
	    imageQuestionGrid.add(answerAImageButton, 1, 0);
	    GridPane.setHalignment(answerBImageButton, HPos.LEFT);
	    imageQuestionGrid.add(answerBImageButton, 1, 1);
	    GridPane.setHalignment(answerCImageButton, HPos.LEFT);
	    imageQuestionGrid.add(answerCImageButton, 1, 2);
	    GridPane.setHalignment(correctAnswerImageButton, HPos.LEFT);
	    imageQuestionGrid.add(correctAnswerImageButton, 1, 3);
	    GridPane.setHalignment(saveButtImage, HPos.RIGHT);
	    imageQuestionGrid.add(saveButtImage, 1, 4);
	    GridPane.setHalignment(returnButtImage, HPos.RIGHT);
	    imageQuestionGrid.add(returnButtImage, 0, 4);
	    
	    //ColumnConstraints textQuestionColumn = new ColumnConstraints();
	    textQuestionGrid.setPadding(new Insets(30));
	    textQuestionGrid.setHgap(20);
	    textQuestionGrid.setVgap(15);
	    imageQuestionGrid.setPadding(new Insets(30));
	    imageQuestionGrid.setHgap(20);
	    imageQuestionGrid.setVgap(15);
	
	    ColumnConstraints column1 = new ColumnConstraints(150);
	    ColumnConstraints column2 = new ColumnConstraints(250);
	
	    textQuestionGrid.getColumnConstraints().addAll(column1,column2);
	    imageQuestionGrid.getColumnConstraints().addAll(column1,column2);	
		
		HBox buttonBoxText = new HBox();
		buttonBoxText.setPadding(new Insets(20));
		
		HBox buttonBoxImages = new HBox();
		buttonBoxImages.setPadding(new Insets(20));
	
		buttonBoxText.getChildren().addAll(returnButtText,createSpacer(),saveButtText);
		buttonBoxImages.getChildren().addAll(returnButtImage,createSpacer(),saveButtImage);

		BorderPane borderpaneText = new BorderPane();
		borderpaneText.prefHeightProperty().bind(window.heightProperty());
		borderpaneText.prefWidthProperty().bind(window.widthProperty());
	
		BorderPane borderpaneImages = new BorderPane();
	
		textQuestionGrid.setAlignment(Pos.CENTER);
		borderpaneText.setCenter(textQuestionGrid);
		borderpaneText.setBottom(buttonBoxText);
	
		imageQuestionGrid.setAlignment(Pos.CENTER);
		borderpaneImages.setCenter(imageQuestionGrid);
		borderpaneImages.setBottom(buttonBoxImages);
	
		
		tab1.setContent(borderpaneText);
		tab2.setContent(borderpaneImages);
	
		VBox vbox = new VBox();
		vbox.getStyleClass().add("add-questions-page");
		vbox.getChildren().addAll(titleBox,questionSetterBox,tabpane);
		vbox.setPadding(new Insets(20,0,0,0));
		Scene scene = new Scene(vbox,700,500);
        scene.getStylesheets().add("NewFile.css");
	    window.setScene(scene);
	    window.show();
	}
	
	public static Node createSpacer() {
	    final Region spacer = new Region();
	    // Make it always grow or shrink according to the available space
	    HBox.setHgrow(spacer, Priority.ALWAYS);
	    return spacer;
	}
	
	public static void imageButtonAction(ImageView iv, Button button) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Add image");		
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File file = fileChooser.showOpenDialog(window);
        if (file != null) { 	
        		String imagepath;
			try {
				imagepath = file.toURI().toURL().toString();
				Image image = new Image(imagepath);        	
				iv.setImage(image);
				button.setText("Image added");
			} catch (MalformedURLException e) {
				e.printStackTrace();
				AlertBox.noDetails("File path error, try another image");
			}
        }
	}
	
	public static void createTextQuestion(TextField questionf,TextField ansA,TextField ansB,TextField ansC,TextField corA) {
		QuizQuestionPOJO quizQuestionPOJO = new QuizQuestionPOJO();
		quizQuestionPOJO.setTextOrImage("Text");
		quizQuestionPOJO.setQuestion(questionf.getText());
		quizQuestionPOJO.setAnswerA(ansA.getText());
		quizQuestionPOJO.setAnswerB(ansB.getText());
		quizQuestionPOJO.setAnswerC(ansC.getText());
		quizQuestionPOJO.setCorrectAnswer(corA.getText());
		listofQuizQuestions.add(quizQuestionPOJO);
		questionf.clear();
		ansA.clear();
		ansB.clear();
		ansC.clear();
		corA.clear();
	}
	
	public static void createImageQuestion(TextField questionf, ImageView ansA,ImageView ansB,ImageView ansC,ImageView corA) {
		QuizQuestionPOJO quizQuestionPOJO = new QuizQuestionPOJO();
		quizQuestionPOJO.setTextOrImage("Image");
		quizQuestionPOJO.setQuestion(questionf.getText());
		quizQuestionPOJO.setAnswerAImage(ansA);
		quizQuestionPOJO.setAnswerBImage(ansB);
		quizQuestionPOJO.setAnswerCImage(ansC);
		quizQuestionPOJO.setcorrectImage(corA);
		listofQuizQuestions.add(quizQuestionPOJO);
		questionf.clear();
	}
}

