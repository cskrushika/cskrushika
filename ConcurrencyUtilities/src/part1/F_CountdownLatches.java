package part1;

import java.util.concurrent.CountDownLatch;

/**
 * The <code>java.util.concurrent.CountDownLatch</code> class implements a countdown latch. Its
 * <code>CountDownLatch(int count)</code> constructor initializes the countdown latch to the specified count. A thread
 * invokes the void await() method to wait until the count has reached zero (or the thread has been interrupted).
 * Subsequent calls to await() for a zero count return immediately. A thread calls void countDown() to decrement the
 * count.
 * 
 * <h3>Working with countdown latches</h3>
 * 
 * Countdown latches are useful for decomposing a problem into smaller pieces and giving a piece to a separate thread,
 * as follows:
 * 
 * <ul>
 * <li>A main thread creates a countdown latch with a count of 1 that's used as a "starting gate" to start a group of
 * worker threads simultaneously.</li>
 * <li>Each worker thread waits on the latch and the main thread decrements this latch to let all worker threads
 * proceed.</li>
 * <li>The main thread waits on another countdown latch initialized to the number of worker threads. When a worker
 * thread completes, it decrements this count.</li>
 * <li>After the count reaches zero (meaning that all worker threads have finished), the main thread proceeds and
 * gathers the results.</li>
 *
 */
public class F_CountdownLatches {
  final static int N = 3;

  public static void main(String[] args) throws InterruptedException {
	CountDownLatch startSignal = new CountDownLatch(1);
	CountDownLatch doneSignal = new CountDownLatch(N);
	for (int i = 0; i < N; ++i) {
	  new Thread(new Worker(startSignal, doneSignal)).start(); // Create 3 threads
	}
	System.out.println("About to let threads proceed");
	startSignal.countDown(); // start all three threads proceed at once. The are being held by startSignal.await() at
							 // line 38
	System.out.println("Doing work");
	System.out.println("Waiting threads to finish");
	doneSignal.await();
	System.out.println("Main thread terminating");
  }
}

class Worker implements Runnable {

  private final static int N = 5;
  private final CountDownLatch startSignal;
  private final CountDownLatch doneSignal;

  Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
	this.startSignal = startSignal;
	this.doneSignal = doneSignal;
  }

  @Override
  public void run() {
	String name = Thread.currentThread().getName();
	try {
	  startSignal.await();
	  for (int i = 0; i < N; i++) {
		int sleep = (int) (Math.random() * 300);
		System.out.printf("Thread %s is working. Sleep for %d\n", name, sleep);
		Thread.sleep(sleep);
	  }
	  System.out.printf("Thread %s is finishing\n", name);
	  /**
	   * whichever thread finishes first, decrements countDown() and waits for all threads to hit countDown() The last
	   * completing thread's countDown() triggers the doneSignal.await() in main to resume
	   */
	  doneSignal.countDown();
	} catch (InterruptedException e) {
	  System.out.println("interrupted");
	}
  }
}
