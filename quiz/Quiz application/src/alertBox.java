import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class alertBox {
	public static void noDetails(String title, String message) {
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); // prevents user interacting with page behind alert box
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label1 = new Label();
		label1.setText(message);
		Button closeButton = new Button("Return");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label1, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
			
	} 

}
