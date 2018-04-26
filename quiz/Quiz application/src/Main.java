import javafx.application.*;
import javafx.stage.*;
import javafx.util.StringConverter;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*; 
import javafx.event.*; 
import javafx.scene.layout.VBox;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;
	static int i = 0;
	static School[] schoolList = new School[5];		// Array of school objects
    static ChoiceBox<School> choiceBox = new ChoiceBox<School>();		// choicebox to choose school
    static ChoiceBox<School> statsChoiceBox = new ChoiceBox<School>();

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
		adminButton.setOnAction(e -> AlertBox.passwordAccess());

	    Button playQuizButton = new Button();
	    playQuizButton.setId("play-button");
	    playQuizButton.setText("Play Quiz!");
	    playQuizButton.setOnAction(e ->{
	    		if (choiceBox.getValue() == null) {
	    			AlertBox.noDetails("Select your school");;
	    		} else if(AddQuestionSet.listofQuizQuestions.size() < 9) {
	    			AlertBox.noDetails("Add full set of questions first");
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
    
  
    public static void engagement() {
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
        Button deleteQuestionButton = new Button("Delete current questions");
        deleteQuestionButton.getStyleClass().add("engagement-buttons");
        Button button4 = new Button ("Return");
        button4.getStyleClass().add("navigation-buttons");

        button1.setOnAction(e ->schoolAdder());
        button2.setOnAction(e -> AddQuestionSet.display());
        button3.setOnAction(e -> {
        		if(choiceBox.getItems().size() == 0) {
        			AlertBox.noDetails("Add school details first");
        		} else if(PlayQuiz.hasQuizbeenPlayed == false) {
        			AlertBox.noDetails("No statistics to show yet");
        		} else {
        			StatsPage.statsOptionsPage();
        		}
        });
        button4.setOnAction(e -> window.close());
        deleteQuestionButton.setOnAction(e ->{
        		if(AddQuestionSet.listofQuizQuestions.size() > 0) {
        			AlertBox.deleteQuestions();
        		} else {
        			AlertBox.noDetails("Nothing to delete");
        		}
        });

        //testing for layout
        HBox titleBar = new HBox();
        titleBar.setAlignment(Pos.CENTER);
        titleBar.getChildren().add(label1);
        
        HBox bottomBar = new HBox();
        bottomBar.setAlignment(Pos.BOTTOM_LEFT);
        bottomBar.getChildren().add(button4);
        
        VBox optionButtons = new VBox(20);
        optionButtons.setAlignment(Pos.CENTER);
        optionButtons.getChildren().addAll(button1,button2,button3,deleteQuestionButton);
        
        BorderPane borderpane = new BorderPane();
        borderpane.getStyleClass().add("engagement-borderpane");
        borderpane.setTop(titleBar);
        borderpane.setCenter(optionButtons);
        borderpane.setBottom(bottomBar);
        borderpane.setPadding(new Insets(20,20,20,20));
              
        Scene scene = new Scene(borderpane, 700, 500);
        scene.getStylesheets().add("NewFile.css");
        window.setScene(scene);
        window.setTitle("Engagement Team Page");
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
					AlertBox.noDetails("Cannot add any more schools");	
				} else {	
					int age = Integer.parseInt(passInput.getText());
					StringBuilder sb = new StringBuilder(nameInput.getText());
					sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
					String schoolN = sb.toString();
					schoolList[i] = new School(schoolN,age);
					choiceBox.getItems().add(schoolList[i]);
					statsChoiceBox.getItems().add(schoolList[i]);
					i ++;
					passInput.setText("");
					nameInput.setText("");
					AlertBox.noDetails("School details added to quiz");	
				}
			} catch (NumberFormatException a) {
				AlertBox.noDetails("Please enter number in year group");
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
        
        /* Ensures choiceBox will display name of the school, not the memory location of the object,
           however choiceBox selection will still get object itself, not string */
		choiceBox.setConverter(new StringConverter<School>() {
		    @Override
		    public String toString(School uni) {
		        return uni.schoolName + " -" + " Year: " + uni.studentAges;
		    }
		    @Override
		    // not used...
		    public School fromString(String s) {
		        return null ;
		    }
		});
		statsChoiceBox.setConverter(new StringConverter<School>() {
		    @Override
		    public String toString(School uni) {
		        return uni.schoolName + " -" + " Year: " + uni.studentAges;
		    }
		    @Override
		    // not used...
		    public School fromString(String s) {
		        return null ;
		    }
		});
		
		Scene scene = new Scene(schoolBorderpane, 400,400);
        scene.getStylesheets().add("NewFile.css");
		window.setScene(scene);
		window.show();
	};

}