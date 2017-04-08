package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The main() method first verifies that a single (URL-based) command-line argument has been specified. It then creates
 * a single-thread executor and a callable that tries to open a connection to this URL, read its contents line by line,
 * and save these lines in a list, which it returns.
 * 
 * The callable is subsequently submitted to the executor and a future representing the list of strings is returned.
 * main() invokes the future's V get(long timeout, TimeUnit unit) method to obtain this list.
 *
 * get() throws TimeoutException when the callable doesn't finish within five seconds. It throws ExecutionException when
 * the callable throws an exception (for instance, the callable will throw java.net.MalformedURLException when the URL
 * is invalid).
 * 
 * Regardless of whether an exception is thrown or not, the executor must be shut down before the application exits. If
 * the executor isn't shut down, the application won't exit because the non-daemon thread-pool threads are still
 * executing.
 * 
 * Execution argument: https://www.wikipedia.org/ Modify timeout in futures.get().
 */
public class C_ReadWebPage_Futures {
  public static void main(String[] args) {
	if (args.length != 1) {
	  System.err.println("Usage: C_ReadWebPage_Futures <url>");
	  return;
	}

	ExecutorService executor = Executors.newSingleThreadExecutor();
	Callable<List<String>> callable = new Callable<List<String>>() {
	  @Override
	  public List<String> call() throws IOException {
		List<String> lines = new ArrayList<String>();
		URL url = new URL(args[0]);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		InputStreamReader isr = new InputStreamReader(conn.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
		  System.out.println(line);
		  lines.add(line);
		}
		return lines;
	  }
	};
	Future<List<String>> future = executor.submit(callable);

	try {
	  List<String> lines = future.get(5, TimeUnit.MICROSECONDS);
	  for (String line : lines)
		System.out.println(line);
	} catch (ExecutionException e) {
	  System.err.println("Callable through exception: " + e.getMessage());
	} catch (InterruptedException | TimeoutException e) {
	  System.err.println("URL not responding within specified time limit");
	}
	executor.shutdown();
  }
}
