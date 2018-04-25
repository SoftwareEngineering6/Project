public class Stopwatch {

static double start;
static double playerElapsedTime;

	public static void StopwatchStart() {
		start = System.currentTimeMillis();
	} 

	public static double elapsedTime() {
		double now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
}
	
	
