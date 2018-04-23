import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.util.ArrayList;
import java.util.List;

public class statsGraphs {
  public static BarChart<String,Number> viewScores() {
    List<Integer> score = school.quizScore;
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> scoreB = new BarChart<>(xAxis, yAxis);

    scoreB.setTitle("Score on Quiz");
    scoreB.setLegendVisible(false);
    xAxis.setLabel("Student");
    yAxis.setLabel("Score (Out of 10)");

    scoreB.setBarGap(3);

    XYChart.Series series = new XYChart.Series();
    for (int i = 0; i < score.size(); i++) {
      series.getData().add(new XYChart.Data(String.valueOf(i+1), score.get(i)));
    }

    scoreB.getData().add(series);
    return scoreB;
  }

  public static BarChart<String,Number> viewTime() {
    List<Double> time = school.timeTaken;
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> timeB = new BarChart<String,Number>(xAxis, yAxis);

    timeB.setTitle("Time Taken");
    timeB.setLegendVisible(false);
    xAxis.setLabel("Student");
    yAxis.setLabel("Time (s)");

    timeB.setBarGap(3);

    XYChart.Series series = new XYChart.Series();
    for (int i = 0; i < time.size(); i++) {
      series.getData().add(new XYChart.Data(String.valueOf(i+1), (time.get(i)/1000)));
    }

    timeB.getData().add(series);
    return timeB;
  }

  public static BarChart<String,Number> viewSkipped() {
    List<Integer> skip = school.skippedQuestions;
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> skipB = new BarChart<String,Number>(xAxis, yAxis);

    skipB.setTitle("Number of Questions Skipped");
    skipB.setLegendVisible(false);
    xAxis.setLabel("Student");
    yAxis.setLabel("No. of Q's Skipped");

    skipB.setBarGap(3);

    XYChart.Series series = new XYChart.Series();
    for (int i = 0; i < skip.size(); i++) {
      series.getData().add(new XYChart.Data(String.valueOf(i+1), skip.get(i)));
    }

    skipB.getData().add(series);
    return skipB;
  }
}
