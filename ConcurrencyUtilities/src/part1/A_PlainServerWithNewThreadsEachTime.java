package part1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This below class has a simple server application. The server thread repeatedly calls socket.accept() and waits for an
 * incoming connection, and then starts a thread to service this request when it arrives.
 *
 * Because this application creates a new thread for each request, it doesn't scale well when faced with a huge number
 * of requests. For example, each created thread requires memory, and too many threads may exhaust the available memory,
 * forcing the application to terminate.
 * 
 * You could solve this problem by changing the task-execution policy. Rather than always creating a new thread, you
 * could use a thread pool, in which a fixed number of threads would service incoming tasks. You would have to rewrite
 * the application to make this change, however.
 * 
 * java.util.concurrent includes the Executor framework, a small framework of types that decouple task submission from
 * task-execution policies. Using the Executor framework, it is possible to easily tune a program's task-execution
 * policy without having to significantly rewrite your code.
 * 
 * Testing: curl http://localhost:9000 <br>
 * OR: for i in `seq 1 10`; do curl http://localhost:9000; done <br>
 * 
 * For each request, a new thread is created
 * 
 * <pre>
 * Output:
 * Request handled by thread: Thread-0
 * Request handled by thread: Thread-1
 * Request handled by thread: Thread-2
 * Request handled by thread: Thread-3
 * Request handled by thread: Thread-4
 * Request handled by thread: Thread-5
 * Request handled by thread: Thread-6
 * Request handled by thread: Thread-7
 * </pre>
 */
public class A_PlainServerWithNewThreadsEachTime {
  public static void main(String[] args) throws IOException {
	ServerSocket socket = new ServerSocket(9000);
	while (true) {
	  final Socket s = socket.accept();
	  Runnable r = new Runnable() {
		@Override
		public void run() {
		  doWork(s);
		}
	  };
	  new Thread(r).start();
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
