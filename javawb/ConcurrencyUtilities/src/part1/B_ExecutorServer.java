package part1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * The key concept is that task submission is decoupled from the task-execution policy, which is described by an
 * Executor implementation. The runnable task is thus able to execute via a new thread, a pooled thread, the calling
 * thread, and so on.
 * 
 * Note that Executor is very limited. For example, you can't shut down an executor or determine whether an asynchronous
 * task has finished. You also can't cancel a running task. For these and other reasons, the Executor framework provides
 * an ExecutorService interface, which extends Executor.
 *
 * Testing: curl http://localhost:9000 <br>
 * OR: for i in `seq 1 10`; do curl http://localhost:9000; done <br>
 * 
 * For each request, a new thread is used from a thread pool of size 5.
 * 
 * <pre>
 * Output: 
 * Request handled by thread: pool-1-thread-1 
 * Request handled by thread: pool-1-thread-2 
 * Request handled by thread: pool-1-thread-3 
 * Request handled by thread: pool-1-thread-4 
 * Request handled by thread: pool-1-thread-5 
 * Request handled by thread: pool-1-thread-1 
 * Request handled by thread: pool-1-thread-2 
 * Request handled by thread: pool-1-thread-3
 * </pre>
 */
public class B_ExecutorServer {
  static Executor pool = Executors.newFixedThreadPool(5);

  public static void main(String[] args) throws IOException {
	ServerSocket server = new ServerSocket(9000);
	while (true) {
	  final Socket s = server.accept();
	  Runnable r = new Runnable() {
		@Override
		public void run() {
		  doWork(s);
		}
	  };
	  pool.execute(r);
	}
  }

  static void doWork(Socket s) {
	System.out.println("Request handled by thread: " + Thread.currentThread().getName());
	try {
	  s.close();
	} catch (IOException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
  }
}
