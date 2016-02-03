package timers;

public class Stopwatch {

	private long startTime;
	private long endTime;
	private long counter;
	private long cumulativeTime = 0;

	public void start() {

		startTime = System.currentTimeMillis();
	}

	public void stop() {

		endTime = System.currentTimeMillis();
		cumulativeTime += (endTime - startTime);
		counter++;
	}

	public long getElapsedTime() {

		return cumulativeTime;
	}

	public long getAverageElapsedTime() {

		if (counter > 0) {
			return cumulativeTime / counter;
		} else {
			return 0;
		}
	}

	public void reset() {

		counter = 0;
		cumulativeTime = 0;
	}
}
