import java.util.Random;
import java.util.ArrayList;

public class testdummydata {
  public ArrayList<ArrayList<Response>> testData() {
    Random rand = new Random();
    ArrayList<ArrayList<Response>> data = new ArrayList<ArrayList<Response>>();
    ArrayList<Integer> qanswered = new ArrayList<Integer>();
    int people = rand.nextInt(20) + 1;
    String[] choices = new String[3];
    choices[0] = "right";
    choices[1] = "wrong";
    choices[2] = "skipped";

    for(int i = 1; i < people; ++i) {
      int answered = rand.nextInt(10) + 1;
      //System.out.println(answered);
      qanswered.add(answered);
      ArrayList<Response> person = new ArrayList<Response>();
      for(int j = 0; j <= answered; ++j) {
        person.add(new Response(choices[rand.nextInt(3)], rand.nextFloat()*10));
      }
      data.add(person);
    }
    return(data);
  }
}
