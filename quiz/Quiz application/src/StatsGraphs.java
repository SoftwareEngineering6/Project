import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;

public class StatsGraphs {
  public static BarChart<String,Number> viewScores(School a) {
	List<Integer> score = new ArrayList<Integer>();
	for(int x=0; x < a.getQuizScore().size();x++) {
		score.add(a.getQuizScore().get(x));
	}

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis(1,10,1);
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

    Integer sum = 0;
    for (Integer sc: score) {
      sum += sc;
    }
    double aveScore = sum.doubleValue() / score.size();
    series.getData().add(new XYChart.Data("Average", aveScore));

    scoreB.getData().add(series);

    for (int i = 0; i < score.size(); i++) {
      XYChart.Data item = (XYChart.Data)series.getData().get(i);
      Tooltip.install(item.getNode(), new Tooltip(item.getYValue().toString() + "/10"));
    }

    scoreB.setPrefWidth(700);
    return scoreB;
  }

  public static BarChart<String,Number> viewTime(School a) {
	List<Double> time = new ArrayList<Double>();
	for(int x=0; x < a.getTimeTaken().size();x++) {
		time.add(a.getTimeTaken().get(x));
	}
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
      series.getData().add(new XYChart.Data(String.valueOf(i+1), (time.get(i))));
    }

    double sum = 0;
    for (double t: time) {
      sum += t;
    }
    double aveTime = sum / time.size();
    series.getData().add(new XYChart.Data("Average", aveTime));

    timeB.getData().add(series);

    for (int i = 0; i < time.size(); i++) {
      XYChart.Data item = (XYChart.Data)series.getData().get(i);
      Tooltip.install(item.getNode(), new Tooltip(item.getYValue().toString() + "s"));
    }

    timeB.setPrefWidth(700);
    return timeB;
  }

  public static BarChart<String,Number> viewSkipped(School a) {
	List<Integer> skip = new ArrayList<Integer>();
	for(int x=0; x < a.getSkippedQuestions().size();x++) {
		skip.add(a.getSkippedQuestions().get(x));
	}
    final CategoryAxis xAxis = new CategoryAxis();

    final NumberAxis yAxis = new NumberAxis(1,10,1);
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

    Integer sum = 0;
    for (Integer s: skip) {
      sum += s;
    }
    double aveSkip = sum.doubleValue() / skip.size();
    series.getData().add(new XYChart.Data("Average", aveSkip));

    skipB.getData().add(series);

    for (int i = 0; i < skip.size(); i++) {
      XYChart.Data item = (XYChart.Data)series.getData().get(i);
      Tooltip.install(item.getNode(), new Tooltip(item.getYValue().toString() + " skipped"));
    }

    skipB.setPrefWidth(700);
    return skipB;
  }
}