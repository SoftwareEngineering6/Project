import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayQuiz {
	public static void display(){
		Stage window = new Stage();
		window.setMinWidth(500);
		window.setMinHeight(500);
		
		VBox layout = new VBox(20);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}

}
