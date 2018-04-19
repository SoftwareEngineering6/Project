import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class time_taken extends Application {
  private TableView<timeData> table = new TableView<timeData>();
  private final ObservableList<timeData> data =
    FXCollections.observableArrayList();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Scene scene = new Scene(new Group());
    stage.setTitle("Time Taken Test");
    stage.setWidth(450);
    stage.setHeight(500);

    final Label label = new Label("Statistics");
    label.setFont(new Font("Arial", 20));

    table.setEditable(true);

    TableColumn qCol = new TableColumn("Question");
    qCol.setMinWidth(100);
    qCol.setCellValueFactory(
      new PropertyValueFactory<timeData, Integer>("question")
    );

    TableColumn meanCol = new TableColumn("Mean Time");
    meanCol.setMinWidth(100);
    meanCol.setCellValueFactory(
      new PropertyValueFactory<timeData, Double>("mean")
    );

    TableColumn tmaxCol = new TableColumn("Max Time");
    tmaxCol.setMinWidth(100);
    tmaxCol.setCellValueFactory(
      new PropertyValueFactory<timeData, Double>("tmax")
    );

    TableColumn tminCol = new TableColumn("Min Time");
    tminCol.setMinWidth(100);
    tminCol.setCellValueFactory(
      new PropertyValueFactory<timeData, Double>("tmin")
    );

    table.setItems(data);
    table.getColumns().addAll(qCol, meanCol, tmaxCol, tminCol);
    data.add(new timeData(1, 2.7, 10.9, 0.3));
    data.add(new timeData(2, 3.6, 11.1, 1.0));
    data.add(new timeData(3, 1.1, 0.2, 4.5));
    data.add(new timeData(4, 5.5, 1.2, 12.6));
    data.add(new timeData(5, 3.4, 0.9, 9.5));
    data.add(new timeData(6, 2.2, 1.1, 5.6));
    data.add(new timeData(7, 4.3, 1.2, 8.7));
    data.add(new timeData(8, 5.6, 2.0, 11.6));
    data.add(new timeData(9, 2.2, 1.3, 6.6));
    data.add(new timeData(10, 1.6, 0.5, 7.8));

    final VBox vbox = new VBox();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, table);

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
  }

  public static class timeData {
    private final SimpleIntegerProperty question;
    private final SimpleDoubleProperty mean;
    private final SimpleDoubleProperty tmax;
    private final SimpleDoubleProperty tmin;

    private timeData(Integer q, Double avg, Double max, Double min) {
      this.question = new SimpleIntegerProperty(q);
      this.mean = new SimpleDoubleProperty(avg);
      this.tmax = new SimpleDoubleProperty(max);
      this.tmin = new SimpleDoubleProperty(min);
    }

    public Integer getQuestion() {
      return question.get();
    }

    public Double getMean() {
      return mean.get();
    }

    public Double getTmax() {
      return tmax.get();
    }

    public Double getTmin() {
      return tmin.get();
    }

    public void setQuestion(Integer q) {
      question.set(q);
    }

    public void setMean(Double avg) {
      mean.set(avg);
    }

    public void setTmax(Double max) {
      tmax.set(max);
    }

    public void setTmin(Double min) {
      tmin.set(min);
    }
  }
}
