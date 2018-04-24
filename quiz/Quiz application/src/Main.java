import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.*;
import javafx.util.StringConverter;
import javafx.scene.*;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;
	static int i = 0;
	static school[] schoolList = new school[5];		// Array of school objects
    static ChoiceBox<school> choiceBox = new ChoiceBox<school>();		// choicebox to choose school
    static ChoiceBox<school> statsChoiceBox = new ChoiceBox<school>();

    	public static void main(String[] args) {
    		launch(args);
    	}

    	public void start(Stage myStage) {
    		BuildTestData.testDataCreator(AddQuestionSet.listofQuizQuestions);
    		DropShadow shadow = new DropShadow();

    		myStage.setTitle("Main Page");

		Label pageTitle = new Label("Welcome");
		pageTitle.setId("page-titles");

		Button adminButton = new Button();
		adminButton.setText("Admin");
		adminButton.getStyleClass().add("navigation-buttons");
		adminButton.setOnAction(e -> engagement());

	    Button playQuizButton = new Button();
	    playQuizButton.setId("play-button");
	    playQuizButton.setText("Play Quiz!");
	    playQuizButton.setOnAction(e ->{
	    		if (choiceBox.getValue() == null) {
	    			alertBox.noDetails("Select your school");;
	    		} else if(AddQuestionSet.listofQuizQuestions.size() < 9) {
	    			alertBox.noDetails("Add full set of questions first");
	    		} else {
	    			PlayQuiz.display();
	    			Stopwatch.StopwatchStart();
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
		borderpane.getStyleClass().add("main-page-borderpane");
		borderpane.setTop(titleBar);
		borderpane.setCenter(options);
		borderpane.setBottom(bottomBar);
		borderpane.setPadding(new Insets(20,20,20,20));

		borderpane.getStyleClass().add("mainpage");
		Scene myScene = new Scene(borderpane, 700, 500);
		myScene.getStylesheets().add("NewFile.css");

		playQuizButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
	            new EventHandler<MouseEvent>() {
	              @Override
	              public void handle(MouseEvent e) {
	            	  playQuizButton.setEffect(shadow);
	            	  myScene.setCursor(Cursor.HAND);
	              }
	            });
		playQuizButton.addEventHandler(MouseEvent.MOUSE_EXITED,
	            new EventHandler<MouseEvent>() {
	              @Override
	              public void handle(MouseEvent e) {
	            	  playQuizButton.setEffect(null);
	            	  myScene.setCursor(Cursor.DEFAULT);
	              }
	            });
		myStage.setScene(myScene);
		myStage.show();
    	}


    public void engagement() {
		Stage window = new Stage();

        //Button 1
        Label label1 = new Label("Engagement Team");
		label1.setId("page-titles");

        Button button1 = new Button ("Add Schools");
        button1.getStyleClass().add("engagement-buttons");
        Button button2 = new Button ("Set Questions");
        button2.getStyleClass().add("engagement-buttons");
        Button button3 = new Button ("Statistics");
        button3.getStyleClass().add("engagement-buttons");
        Button button4 = new Button ("Return");
        button4.getStyleClass().add("navigation-buttons");

        button1.setOnAction(e ->schoolAdder());
        button2.setOnAction(e -> AddQuestionSet.display());
        button3.setOnAction(e -> {
        		if(choiceBox.getItems().size() == 0) {
        			alertBox.noDetails("Add school details first");
        		} else {
        			statsPage();
        		}
        });
        button4.setOnAction(e -> window.close());

        //testing for layout
        HBox titleBar = new HBox();
        titleBar.setAlignment(Pos.CENTER);
        titleBar.getChildren().add(label1);

        HBox bottomBar = new HBox();
        bottomBar.setAlignment(Pos.BOTTOM_LEFT);
        bottomBar.getChildren().add(button4);

        VBox optionButtons = new VBox(20);
        optionButtons.setAlignment(Pos.CENTER);
        optionButtons.getChildren().addAll(button1,button2,button3);

        BorderPane borderpane = new BorderPane();
        borderpane.getStyleClass().add("engagement-borderpane");
        borderpane.setTop(titleBar);
        borderpane.setCenter(optionButtons);
        borderpane.setBottom(bottomBar);
        borderpane.setPadding(new Insets(20,20,20,20));

        scene1 = new Scene(borderpane, 700, 500);
        scene1.getStylesheets().add("NewFile.css");
        window.setScene(scene1);
        window.setTitle("Engagement Team Page");
        window.show();
    }

    public static void statsPage() {
        Stage window = new Stage();
        window.setTitle("Statistics");
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
        Label pageTitle = new Label("Statistics");
        pageTitle.setId("page-titles");
        statsChoiceBox.getSelectionModel().selectFirst();

        Button closeButton = new Button("Return");
        closeButton.setOnAction(e -> window.close());

        HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        title.getChildren().addAll(pageTitle,statsChoiceBox);

        VBox graphs = new VBox(10);
        graphs.setAlignment(Pos.CENTER);
        graphs.getChildren().addAll(statsGraphs.viewScores(statsChoiceBox.getSelectionModel().getSelectedItem())
        		, statsGraphs.viewTime(statsChoiceBox.getSelectionModel().getSelectedItem())
        		, statsGraphs.viewSkipped(statsChoiceBox.getSelectionModel().getSelectedItem()));

        HBox functionButtons = new HBox(20);
        functionButtons.setAlignment(Pos.BOTTOM_RIGHT);
        functionButtons.getChildren().addAll(closeButton);

        BorderPane graphsBorderpane = new BorderPane();
        graphsBorderpane.setTop(title);
        graphsBorderpane.setCenter(graphs);
        graphsBorderpane.setBottom(functionButtons);
        graphsBorderpane.setPadding(new Insets(20));

        statsChoiceBox.valueProperty().addListener(new ChangeListener<school>() {
	        @Override public void changed(ObservableValue ov, school t, school t1) {
	        	graphs.getChildren().remove(2);
	        	graphs.getChildren().remove(1);
	        	graphs.getChildren().remove(0);
	        graphs.getChildren().add(statsGraphs.viewScores(statsChoiceBox.getSelectionModel().getSelectedItem()));
	        graphs.getChildren().add(statsGraphs.viewTime(statsChoiceBox.getSelectionModel().getSelectedItem()));
	        graphs.getChildren().add(statsGraphs.viewSkipped(statsChoiceBox.getSelectionModel().getSelectedItem()));
	        }
	      });

        Scene scene = new Scene(graphsBorderpane, 1000, 1000);
        window.setScene(scene);
        window.show();
      }

    public static void schoolAdder() {
		Stage window = new Stage();
		Label pageTitle = new Label("Add school details");
		pageTitle.setId("page-titles");

		Label nameLabel = new Label("School name:");
		TextField nameInput = new TextField();
		nameInput.setMaxWidth(200);
		nameInput.setPromptText("Enter school name");
		Label passLabel = new Label("Year group:");
		TextField passInput = new TextField();
		passInput.setMaxWidth(200);
		passInput.setPromptText("Enter year group");
		Button addSchoolButton = new Button("Add school");
		addSchoolButton.getStyleClass().add("navigation-buttons");

		addSchoolButton.setOnAction(e -> {
			try {
				if (i >= 5) {
					alertBox.noDetails("Cannot add any more schools");
				} else {
					int age = Integer.parseInt(passInput.getText());
					schoolList[i] = new school(nameInput.getText(),age);
					choiceBox.getItems().add(schoolList[i]);
					statsChoiceBox.getItems().add(schoolList[i]);
					i ++;
					passInput.setText("");
					nameInput.setText("");
					alertBox.noDetails("School details added to quiz");
				}
			} catch (NumberFormatException a) {
				alertBox.noDetails("No details input");
			}
		});

		Button closeButton = new Button("Return");
		closeButton.getStyleClass().add("navigation-buttons");
		closeButton.setOnAction(e -> window.close());

		// page layout
		HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        title.getChildren().addAll(pageTitle);

		VBox labels = new VBox(10);
        labels.setAlignment(Pos.CENTER);
        labels.getChildren().addAll(nameLabel, nameInput, passLabel, passInput);

        HBox functionButtons = new HBox(20);
        functionButtons.setAlignment(Pos.BOTTOM_CENTER);
        functionButtons.getChildren().addAll(closeButton,AddQuestionSet.createSpacer(),addSchoolButton);

        BorderPane schoolBorderpane = new BorderPane();
        schoolBorderpane.getStyleClass().add("school-adder-borderpane");
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
		statsChoiceBox.setConverter(new StringConverter<school>() {
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

		Scene scene = new Scene(schoolBorderpane, 400,400);
        scene.getStylesheets().add("NewFile.css");
		window.setScene(scene);
		window.show();
	};

}
