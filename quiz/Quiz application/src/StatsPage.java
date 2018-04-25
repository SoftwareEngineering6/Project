import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
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
        
        downloadButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save statistics");
			File file = fileChooser.showSaveDialog(window);
            if(file != null){
            		WriteToCsv.download(file);
            	    AlertBox.noDetails("Download Complete!");
            	}
	    	});

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
        GridPane gridpane = new GridPane();
        Label label = new Label("Choose school: ");
        label.setStyle("	-fx-font-size: 16; -fx-text-fill: #DAFFEF");
        gridpane.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.RIGHT);
        gridpane.add(Main.statsChoiceBox, 1, 0);
        GridPane.setHalignment(Main.statsChoiceBox, HPos.LEFT);
        gridpane.setHgap(10);
        selectionHbox.setAlignment(Pos.CENTER);
        selectionHbox.setPadding(new Insets(20));
        selectionHbox.getChildren().addAll(gridpane);
        
        VBox top = new VBox();
        top.getChildren().addAll(title, selectionHbox);
        
        TabPane tabpane = new TabPane();
        tabpane.getStyleClass().add("chart-tab");
        tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        Tab tab1 = new Tab("Student Scores");
        Tab tab2 = new Tab("Time Taken");
        Tab tab3 = new Tab("Times Skipped");
        tabpane.getTabs().addAll(tab1, tab2, tab3);
        
        BorderPane tab1Borderpane = new BorderPane();
        HBox scoresBox = new HBox();
        scoresBox.setAlignment(Pos.CENTER);
        scoresBox.getChildren().add(StatsGraphs.viewScores(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
        tab1Borderpane.setCenter(scoresBox);
        
        BorderPane tab2Borderpane = new BorderPane();
        HBox timesBox = new HBox();
        timesBox.setAlignment(Pos.CENTER);
        timesBox.getChildren().add(StatsGraphs.viewTime(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
        tab2Borderpane.setCenter(timesBox);
        
        BorderPane tab3Borderpane = new BorderPane();
        HBox skippedBox = new HBox();
        skippedBox.setAlignment(Pos.CENTER);
        skippedBox.getChildren().add(StatsGraphs.viewSkipped(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
        tab3Borderpane.setCenter(skippedBox);
        
        tab1.setContent(tab1Borderpane);
        tab2.setContent(tab2Borderpane);
        tab3.setContent(tab3Borderpane);

        HBox functionButtons = new HBox(20);
        functionButtons.setAlignment(Pos.BOTTOM_LEFT);
        functionButtons.getChildren().addAll(closeButton);

        BorderPane graphsBorderpane = new BorderPane();
        graphsBorderpane.setTop(top);
        graphsBorderpane.setCenter(tabpane);
        graphsBorderpane.setBottom(functionButtons);
        graphsBorderpane.setPadding(new Insets(20));
        graphsBorderpane.getStyleClass().add("engagement-borderpane");
        
        Main.statsChoiceBox.valueProperty().addListener(new ChangeListener<School>() {
	        @SuppressWarnings("rawtypes")
			@Override public void changed(ObservableValue ov, School t, School t1) {
	        	scoresBox.getChildren().remove(0);
	        	timesBox.getChildren().remove(0);
	        	skippedBox.getChildren().remove(0);
	        	scoresBox.getChildren().add(StatsGraphs.viewScores(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
	        	timesBox.getChildren().add(StatsGraphs.viewTime(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
	        	skippedBox.getChildren().add(StatsGraphs.viewSkipped(Main.statsChoiceBox.getSelectionModel().getSelectedItem()));
	        }
	      });

        Scene scene = new Scene(graphsBorderpane, 900, 700);
        scene.getStylesheets().add("NewFile.css");
        window.setScene(scene);
        window.show();
      }

}
