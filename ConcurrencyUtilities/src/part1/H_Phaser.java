package part1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * The application creates a pair of runnable tasks that each report the time (in milliseconds relative to the Unix
 * epoch) at which its starts to run. Compile and run this application, and you should observe output that's similar to
 * the following:</br>
 * </br>
 * 
 * Thread-0 running at 1447066997263 </br>
 * Thread-1 running at 1447066997263 </br>
 * </br>
 * As you would expect from countdown latch behavior, both threads start running at (in this case) the same time even
 * though a thread may have been delayed by as much as 349 milliseconds thanks to the presence of Thread.sleep().</br>
 * </br>
 * Comment out phaser.arriveAndAwaitAdvance(); // await all creation and you should now observe the threads starting at
 * radically different times, as illustrated below:</br>
 * </br>
 * 
 * Thread-1 running at 1447067071545</br>
 * Thread-0 running at 1447067071726</br>
 */
public class H_Phaser {
  public static void main(String[] args) {
	List<Runnable> tasks = new ArrayList<>();
	tasks.add(new Runnable() {
	  @Override
	  public void run() {
		System.out.printf("%s running at %d%n", Thread.currentThread().getName(), System.currentTimeMillis());
	  }
	});
	tasks.add(new Runnable() {
	  @Override
	  public void run() {
		System.out.printf("%s running at %d%n", Thread.currentThread().getName(), System.currentTimeMillis());
	  }
	});
	runTasks(tasks);
  }

  static void runTasks(List<Runnable> tasks) {
	final Phaser phaser = new Phaser(1); // (1) to create and start threads
	for (final Runnable task : tasks) {
	  phaser.register();
	  new Thread() {
		// The purpose of this thread is to sleep for a while before proceeding towards task.run().
		// task.run() is preceded by phaser.arriveAndAwaitAdvance(). This makes the threads wait till all the threads
		// arrive here.
		// The threads are started when phaser.arriveAndDeregister() is executed
		@Override
		public void run() {
		  try {
			Thread.sleep(50 + (int) (Math.random() * 300));
		  } catch (InterruptedException e) {
			System.out.println("interrupted thread");
		  }
		  // phaser.arriveAndAwaitAdvance();
		  task.run();
		}
	  }.start();
	}
	// allow threads to start and deregister self
	phaser.arriveAndDeregister();
  }
}
