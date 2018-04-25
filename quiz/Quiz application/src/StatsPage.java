import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StatsPage {
	
	public static void statsOptionsPage() {
        Stage window = new Stage();
        Label pageTitle = new Label("Statistics");
        pageTitle.setId("page-titles");

        Button viewButton = new Button("View Statistics");
        viewButton.getStyleClass().add("engagement-buttons");
        viewButton.setOnAction(e -> StatsPage.viewStats());

        Button downloadButton = new Button("Download Statistics");
        downloadButton.getStyleClass().add("engagement-buttons");
        downloadButton.setOnAction(e -> WriteToCsv.download());

        Button closeButton = new Button("Return");
        closeButton.getStyleClass().add("navigation-buttons");
        closeButton.setOnAction(e -> window.close());

        HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        title.getChildren().addAll(pageTitle);

        VBox functionButtons = new VBox(10);
        functionButtons.setAlignment(Pos.CENTER);
        functionButtons.getChildren().addAll(viewButton, downloadButton);
        
        HBox hbox = new HBox();
        hbox.getChildren().add(closeButton);
        hbox.setAlignment(Pos.BOTTOM_LEFT);

        BorderPane statsBorderpane = new BorderPane();
        statsBorderpane.setTop(title);
        statsBorderpane.setCenter(functionButtons);
        statsBorderpane.setBottom(hbox);
        statsBorderpane.setPadding(new Insets(20,20,20,20));
        statsBorderpane.getStyleClass().add("engagement-borderpane");

        Scene scene = new Scene(statsBorderpane, 300,300);
        scene.getStylesheets().add("NewFile.css");
        window.setScene(scene);
        window.show();
      }
	
    public static void viewStats() {
        Stage window = new Stage();
        Label pageTitle = new Label("Statistics");
        pageTitle.setId("page-titles");
        Main.statsChoiceBox.getSelectionModel().selectFirst();

        Button closeButton = new Button("Return");
        closeButton.getStyleClass().add("navigation-buttons");
        closeButton.setOnAction(e -> window.close());

        HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        title.getChildren().addAll(pageTitle);
        HBox selectionHbox = new HBox();
        selectionHbox.setAlignment(Pos.CENTER);
        selectionHbox.getChildren().add(Main.statsChoiceBox);
        VBox top = new VBox();
        top.getChildren().addAll(title, selectionHbox);

        VBox graphs = new VBox(10);
        graphs.setAlignment(Pos.CENTER);
        graphs.getChildren().addAll(StatsGraphs.viewScores(Main.statsChoiceBox.getSelectionModel().getSelectedItem())
        		, StatsGraphs.viewTime(Main.statsChoiceBox.getSelectionModel().getSelectedItem())
        		, StatsGraphs.viewSkipped(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));

        HBox functionButtons = new HBox(20);
        functionButtons.setAlignment(Pos.BOTTOM_LEFT);
        functionButtons.getChildren().addAll(closeButton);

        BorderPane graphsBorderpane = new BorderPane();
        graphsBorderpane.setTop(top);
        graphsBorderpane.setCenter(graphs);
        graphsBorderpane.setBottom(functionButtons);
        graphsBorderpane.setPadding(new Insets(20));
        graphsBorderpane.getStyleClass().add("engagement-borderpane");
        
        Main.statsChoiceBox.valueProperty().addListener(new ChangeListener<School>() {
	        @SuppressWarnings("rawtypes")
			@Override public void changed(ObservableValue ov, School t, School t1) {
	        	graphs.getChildren().remove(2);
	        	graphs.getChildren().remove(1);
	        	graphs.getChildren().remove(0);
	        graphs.getChildren().add(StatsGraphs.viewScores(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
	        graphs.getChildren().add(StatsGraphs.viewTime(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
	        graphs.getChildren().add(StatsGraphs.viewSkipped(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
	        }
	      });

        Scene scene = new Scene(graphsBorderpane, 900, 700);
        scene.getStylesheets().add("NewFile.css");
        window.setScene(scene);
        window.show();
      }

}
