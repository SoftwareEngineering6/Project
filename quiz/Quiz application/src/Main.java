import javafx.application.*;
import javafx.stage.*;
import javafx.util.StringConverter;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.FontWeight;
import javafx.scene.chart.*;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;
	static int i = 0;
	static school[] schoolList = new school[5];		// Array of school objects
    static ChoiceBox<school> choiceBox = new ChoiceBox<school>();			// choicebox to choose school

    	public static void main(String[] args) {
    		launch(args);
    	}

    	public void start(Stage myStage) {  // --> Create the App Window
    		BuildTestData.testDataCreator(AddQuestionSet.listofQuizQuestions);

    		myStage.setTitle("Main Page");

        choiceBox.setStyle("-fx-background-color: #D3D3D3;");
        choiceBox.setPadding(new Insets(8, 120, 0, 8));

        DropShadow titleShadow = new DropShadow();
        titleShadow.setOffsetX(2.0f);
        titleShadow.setOffsetY(2.0f);
		Text pageTitle = new Text();
		pageTitle.setText("Welcome");

    pageTitle.setEffect(titleShadow);
    pageTitle.setCache(true);
    pageTitle.setX(20);
    pageTitle.setY(100);
    pageTitle.setFont(Font.font(null, FontWeight.BOLD, 50));
    pageTitle.setFill(Color.BLACK);

		Button adminButton = new Button();
		adminButton.setText("Admin");
		adminButton.setOnAction(e -> engagement());

	    Button playQuizButton = new Button();
	    playQuizButton.setText("Start the QUIZ!");
      playQuizButton.setStyle("-fx-background-color: #D3D3D3;");
      playQuizButton.setStyle("-fx-font: 22 arial;");
	    playQuizButton.setOnAction(e ->{
	    		if (choiceBox.getValue() == null) {
	    			alertBox.noDetails("empty", "Select your school");;
	    		} else if(AddQuestionSet.listofQuizQuestions.size() < 9) {
	    			alertBox.noDetails("", "Add full set of questions first");
	    		} else {
	    			PlayQuiz.display();
	    		}
	    });

		HBox titleBar = new HBox();
		titleBar.setAlignment(Pos.CENTER);
		titleBar.getChildren().add(pageTitle);

		HBox bottomBar = new HBox();
		bottomBar.setAlignment(Pos.BOTTOM_RIGHT);
		bottomBar.getChildren().add(adminButton);

		VBox options = new VBox(20);
		options.setAlignment(Pos.CENTER);
		options.getChildren().addAll(playQuizButton, choiceBox);

		BorderPane borderpane = new BorderPane();
		borderpane.setTop(titleBar);
		borderpane.setCenter(options);
		borderpane.setBottom(bottomBar);
		borderpane.setPadding(new Insets(20,20,20,20));

		Scene myScene = new Scene(borderpane, 500, 500);

		// Show the stage and its scene.
		myStage.setScene(myScene);
		myStage.show();
    	}


    public void engagement() {
		Stage window = new Stage();

        //Button 1
        Label label1 = new Label("Engagement Team");
	    label1.setStyle("-fx-font: 26 arial;");
        Button button1 = new Button ("Add Schools");
        Button button2 = new Button ("Set Questions");
        Button button3 = new Button ("Statistics");
        Button button4 = new Button ("Return");

        button1.setPadding(new Insets(10, 30, 10, 30));
        button2.setPadding(new Insets(10, 30, 10, 30));
        button3.setPadding(new Insets(10, 30, 10, 30));
        button4.setPadding(new Insets(10, 30, 10, 30));

        button1.setStyle("-fx-font: 20 arial;");
        button2.setStyle("-fx-font: 20 arial;");
        button3.setStyle("-fx-font: 20 arial;");
        button4.setStyle("-fx-font: 16 arial;");

        button1.setOnAction(e ->schoolAdder());
        button2.setOnAction(e -> AddQuestionSet.display());
        button3.setOnAction(e -> statsPage());
        button4.setOnAction(e -> window.close());


        //testing for layout
        HBox titleBar = new HBox();
        titleBar.setAlignment(Pos.CENTER);
        titleBar.getChildren().add(label1);

        HBox bottomBar = new HBox();
        bottomBar.setAlignment(Pos.BOTTOM_RIGHT);
        bottomBar.getChildren().add(button4);

        VBox optionButtons = new VBox(20);
        optionButtons.setAlignment(Pos.CENTER);
        optionButtons.getChildren().addAll(button1,button2,button3);

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(titleBar);
        borderpane.setCenter(optionButtons);
        borderpane.setBottom(bottomBar);
        borderpane.setPadding(new Insets(20,20,20,20));

        scene1 = new Scene(borderpane, 500, 500);

        window.setScene(scene1);
        window.setTitle("Engagement Team Page");
        window.show();
    }

    public static void statsPage() {
      Stage window = new Stage();
      window.setTitle("Page title");
      Label pageTitle = new Label("Statistics");

      Button viewButton = new Button("View Statistics");
      viewButton.setOnAction(e -> viewStats());

      Button downloadButton = new Button("Download Statistics");
      downloadButton.setOnAction(e -> writeToCsv.download());

      Button closeButton = new Button("Return");
      closeButton.setOnAction(e -> window.close());

      HBox title = new HBox();
      title.setAlignment(Pos.CENTER);
      title.getChildren().addAll(pageTitle);

      VBox functionButtons = new VBox(10);
      functionButtons.setAlignment(Pos.CENTER);
      functionButtons.getChildren().addAll(viewButton, downloadButton, closeButton);

      BorderPane statsBorderpane = new BorderPane();
      statsBorderpane.setTop(title);
      statsBorderpane.setCenter(functionButtons);
      statsBorderpane.setPadding(new Insets(20,20,20,20));

      Scene scene = new Scene(statsBorderpane, 300,300);
      window.setScene(scene);
      window.show();
    }

    public static void viewStats() {
      Stage window = new Stage();
      window.setTitle("Page title");
      Label pageTitle = new Label("Statistics");

      BarChart<String,Number> scores = statsGraphs.viewScores();
      BarChart<String,Number> times = statsGraphs.viewTime();
      BarChart<String,Number> skipped = statsGraphs.viewSkipped();

      Button closeButton = new Button("Return");
      closeButton.setOnAction(e -> window.close());

      HBox title = new HBox();
      title.setAlignment(Pos.CENTER);
      title.getChildren().addAll(pageTitle);

      VBox graphs = new VBox(10);
      graphs.setAlignment(Pos.CENTER);
      graphs.getChildren().addAll(scores, times, skipped);

      HBox functionButtons = new HBox(20);
      functionButtons.setAlignment(Pos.BOTTOM_RIGHT);
      functionButtons.getChildren().addAll(closeButton);

      BorderPane graphsBorderpane = new BorderPane();
      graphsBorderpane.setTop(title);
      graphsBorderpane.setCenter(graphs);
      graphsBorderpane.setBottom(functionButtons);
      graphsBorderpane.setPadding(new Insets(20, 20, 20, 20));

      Scene scene = new Scene(graphsBorderpane, 600, 600);
      window.setScene(scene);
      window.show();
    }

    public static void schoolAdder() {
		Stage window = new Stage();
		window.setTitle("Page title");
		Label pageTitle = new Label("Add school details");

		Label nameLabel = new Label("School name:");
		TextField nameInput = new TextField();
		nameInput.setMaxWidth(200);
		nameInput.setPromptText("Enter school name");
		Label passLabel = new Label("Year group:");
		TextField passInput = new TextField();
		passInput.setMaxWidth(200);
		passInput.setPromptText("Enter year group");
		Button loginButton = new Button("Add school");
		loginButton.setOnAction(e -> {
			try {
				if (i >= 5) {
					alertBox.noDetails("Cannot add", "Cannot add any more schools");
				} else {
					int age = Integer.parseInt(passInput.getText());
					schoolList[i] = new school(nameInput.getText(),age);
					choiceBox.getItems().add(schoolList[i]);
					i ++;
					passInput.setText("");
					nameInput.setText("");
					alertBox.noDetails("School added", "School details added to quiz");
				}
			} catch (NumberFormatException a) {
				alertBox.noDetails("No input", "No details input");
			}
		});

		Button closeButton = new Button("Return");
    closeButton.setStyle("-fx-font: 16 arial");
		closeButton.setOnAction(e -> window.close());

		// page layout
		HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        title.getChildren().addAll(pageTitle);

		VBox labels = new VBox(10);
        labels.setAlignment(Pos.CENTER);
        labels.getChildren().addAll(nameLabel, nameInput, passLabel, passInput);

        HBox functionButtons = new HBox(20);
        functionButtons.setAlignment(Pos.BOTTOM_RIGHT);
        functionButtons.getChildren().addAll(loginButton, closeButton);

        BorderPane schoolBorderpane = new BorderPane();
        schoolBorderpane.setTop(title);
        schoolBorderpane.setBottom(functionButtons);
        schoolBorderpane.setCenter(labels);
        schoolBorderpane.setPadding(new Insets(20,20,20,20));
		//

        // Ensures choiceBox will display name of the school whilst still pointing to memory location
        // of the school object, rather than a string
		choiceBox.setConverter(new StringConverter<school>() {
		    @Override
		    public String toString(school uni) {
		        return uni.schoolName + " -" + " Year: " + uni.studentAges;
		    }
		    @Override
		    // not used...
		    public school fromString(String s) {
		        return null ;
		    }
		});


		Scene scene = new Scene(schoolBorderpane, 300,300);
		window.setScene(scene);
		window.show();
	};

    private static void closeNotification() {
    	System.out.println("Closing app");
    }

}
