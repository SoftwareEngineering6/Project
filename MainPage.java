import javafx.application.*; // Contains all the JavaFX programs
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.geometry.*; 
import javafx.collections.*; 
import javafx.event.*; 
import javafx.scene.layout.VBox;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
 
public class MainPage extends Application { 
 
  ComboBox<String> schoolList; 
  Label response; 
 
  public static void main(String[] args) { 
    launch(args);   
  } 
 
  public void start(Stage myStage) {  // --> Create the App Window 
 
    myStage.setTitle("Main Page"); 
 
    // Use a FlowPane for the root node. In this case, 
    // vertical and horizontal gaps of 10. 
    FlowPane rootNode = new FlowPane(10, 10); 
 
    // Padding top of the list. 
    rootNode.setPadding(new Insets(30, 0, 0, 0)); 
 
    // Center the list at top of the scene.  
    rootNode.setAlignment(Pos.TOP_CENTER);  

    VBox layout = new VBox(30);
    layout.setStyle("-fx-background: #C0C0C0;");
 
    // Create a scene 
    Scene myScene = new Scene(rootNode, 500, 500); 
 
    // Set the scene on the stage. 
    myStage.setScene(myScene); 

    Text text = new Text();
    text.setText("WELCOME");
    text.setStyle("-fx-font: 26 arial;");

    // Create a label. 
    response = new Label(); 
 
    // Create an ObservableList of entries for the combo box. 
    ObservableList<String> schools = FXCollections.observableArrayList("School1", "School2", "School3", 
                                                                          "School4", "School5", 
                                                                          "School6");  
    // Create a dropdown school list
    // Styling it 
    schoolList = new ComboBox<String>(schools); 
 
    schoolList.setValue("School1"); 
    schoolList.setPrefWidth(400);
    schoolList.setStyle("-fx-font: 24 arial;");
    response.setPadding(new Insets(100));
    // Set the response label to indicate the default selection. 
    // Styling it
    response.setText("Selected school is " + schoolList.getValue()); 
    response.setPadding(new Insets(150)); 
    response.setStyle("-fx-font: 24 arial;");
 
    // Listen for events on the school list. 
    schoolList.setOnAction(new EventHandler<ActionEvent>() { 
      public void handle(ActionEvent ae) { 
        response.setText("Selected school is " + schoolList.getValue()); 
      } 
    }); 

    Button btn1 = new Button();
    btn1.setText("Admin");
    btn1.setPadding(new Insets(10));
    schoolList.setPrefWidth(80);
    Button btn2 = new Button();
    btn2.setText("Start the QUIZ!");
    btn2.setPadding(new Insets(20));
    schoolList.setPrefWidth(150);
    btn1.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Admin!");
        }
    });
    btn2.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Start the QUIZ!");
        }
    });

    Pane root = new Pane();
    btn2.setLayoutX(350);
    btn2.setLayoutY(520);
    btn1.setLayoutX(450);
    btn1.setLayoutY(320);
    root.getChildren().add(btn1);
    root.getChildren().add(btn2);
 
    // Add all the elements to the scene. 
    rootNode.getChildren().addAll(text, schoolList, response, root); 
 
    // Show the stage and its scene. 
    myStage.show(); 
  } 
}