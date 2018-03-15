import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.Random;
import java.util.ArrayList;


public class result_bar extends Application {
  @Override public void start(Stage stage) {
        testdummydata d = new testdummydata();
        ArrayList<ArrayList<Response>> data = d.testData();
        int[] right = new int[11];
        int[] wrong = new int[11];
        int[] skipped = new int[11];
        stage.setTitle("Bar Chart Test");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Question Summary");
        xAxis.setLabel("Question");
        yAxis.setLabel("Result");


        bc.setBarGap(3);
        bc.setCategoryGap(20);

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Right");
        for(int i=0; i < data.size(); ++i) {
          for(int j=0; j < data.get(i).size(); ++j) {
            if(data.get(i).get(j).answer == "right") {
              ++right[j];
            } else if (data.get(i).get(j).answer == "wrong") {
              ++wrong[j];
            } else if (data.get(i).get(j).answer == "skipped") {
              ++skipped[j];
            } else {
              continue;
            }
          }
        }

        System.out.println(right[1]);
        for(int i = 0; i < 10; ++i) {
          series1.getData().add(new XYChart.Data(String.valueOf(i), right[i]));
        }

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Wrong");
        for(int i = 0; i < 10; ++i) {
          series2.getData().add(new XYChart.Data(String.valueOf(i), wrong[i]));
        }

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Skipped");
        for(int i = 0; i < 10; ++i) {
          series1.getData().add(new XYChart.Data(String.valueOf(i), skipped[i]));
        }

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();

      }

      public static void main(String[] args) {
        launch(args);
      }
}
