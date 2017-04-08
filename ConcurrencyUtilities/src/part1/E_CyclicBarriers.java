package part1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Cyclic barriers can be used to perform lengthy calculations by breaking them into smaller individual tasks
 * 
 * The below main() method first creates a barrier action that's run by the last thread to reach the barrier. Next, a
 * cyclic barrier is created. When three players arrive it trips and executes the barrier action.
 * 
 * main() now creates a runnable that outputs various status messages and invokes await(), followed by a three-executor
 * array. Each executor runs this runnable and shuts down after the runnable finishes. Output:
 * 
 * Output: </br>
 * Thread pool-1-thread-1 about to join the game after 1085 ms </br>
 * Thread pool-2-thread-1 about to join the game after 1819 ms </br>
 * Thread pool-3-thread-1 about to join the game after 1430 ms </br>
 * Thread pool-2-thread-1 executing barrier [Thread2 joins in last as it waits most(1819ms)]</br>
 * Thread pool-2-thread-1 has joined the game </br>
 * Thread pool-3-thread-1 has joined the game </br>
 * Thread pool-1-thread-1 has joined the game </br>
 * 
 */
public class E_CyclicBarriers {
  public static void main(String[] args) {
	Runnable action = new Runnable() {
	  @Override
	  public void run() {
		System.out.printf("Thread %s executing barrier\n", Thread.currentThread().getName());
	  }
	};

	final CyclicBarrier cb = new CyclicBarrier(3, action);

	Runnable task = new Runnable() {
	  @Override
	  public void run() {
		String name = Thread.currentThread().getName();
		int sleep = (int) (Math.random() * 2000);
		System.out.printf("Thread %s about to join the game after %d ms\n", name, sleep);
		try {
		  Thread.currentThread().sleep(sleep);
		} catch (InterruptedException e1) {
		  // TODO Auto-generated catch block
		  e1.printStackTrace();
		}
		try {
		  cb.await(); // Each of the executor waits until all the others are upto this point. (A blocking call)
		} catch (Exception e) {
		  System.out.println("Barrier is broken");
		}
		System.out.printf("Thread %s has joined the game\n", name);
	  }
	};

	ExecutorService[] es = new ExecutorService[] { Executors.newSingleThreadExecutor(), Executors.newSingleThreadExecutor(),
		Executors.newSingleThreadExecutor() };

	for (ExecutorService exec : es) {
	  exec.execute(task);
	  exec.shutdown();
	}
  }
}
