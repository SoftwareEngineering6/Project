import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.event.*; 

public class PlayQuizNew {
	public static void display(){
		Stage window = new Stage();

		FlowPane rootNode = new FlowPane(10, 10);

		Scene scene = new Scene(rootNode, 500, 500);

		Text question = new Text();
    	question.setText("Question 1");
    	question.setStyle("-fx-font: 28 arial;");
    	question.setLayoutY(50);
    	question.setLayoutX(115);


		Button btn1 = new Button();
		btn1.setText("answer1");
	    btn1.setLayoutY(120);
	    btn1.setLayoutX(10);
	    btn1.setPadding(new Insets(20));
   	 	btn1.setPrefWidth(200);

	    Button btn2 = new Button();
	    btn2.setText("answer2");
	    btn2.setLayoutY(120);
	    btn2.setLayoutX(220);
	    btn2.setPadding(new Insets(20));
   	 	btn2.setPrefWidth(200);

	    Button btn3 = new Button();
	    btn3.setText("answer3");
	    btn3.setLayoutY(200);
	    btn3.setLayoutX(10);
	    btn3.setPadding(new Insets(20));
   	 	btn3.setPrefWidth(200);

	    Button btn4 = new Button();
	    btn4.setText("answer4");
	    btn4.setLayoutY(200);
	    btn4.setLayoutX(220);
	    btn4.setPadding(new Insets(20));
   	 	btn4.setPrefWidth(200);

   	 	Button btn5 = new Button();
	    btn5.setText("Reset Quiz");
	    btn5.setLayoutY(390);
	    btn5.setLayoutX(10);
	    btn5.setPadding(new Insets(10));
   	 	btn5.setPrefWidth(80);

   	 	Button btn6 = new Button();
	    btn6.setText("Skip Question");
	    btn6.setLayoutY(390);
	    btn6.setLayoutX(390);
	    btn6.setPadding(new Insets(10));
   	 	btn6.setPrefWidth(80);

	    Pane root = new Pane();
		root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6);

		btn1.setOnAction(e -> {
			Stage window1 = new Stage();
			window1.setTitle("Correct/Wrong answer");

			FlowPane rootNode1 = new FlowPane(10, 10);

			Scene scene1 = new Scene(rootNode1);

			Button btn7 = new Button();
		    btn7.setText("Next");
		    btn7.setLayoutY(290);
		    btn7.setLayoutX(290);
		    btn7.setPadding(new Insets(10));
	   	 	btn7.setPrefWidth(80);

	   	 	Pane root1 = new Pane();
			root1.getChildren().add(btn7);

			rootNode1.getChildren().addAll(root1);

			window1.setScene(scene1);
			window1.show();
		});

		rootNode.getChildren().addAll(question, root);

        window.setScene(scene);
		window.show();

	}

}