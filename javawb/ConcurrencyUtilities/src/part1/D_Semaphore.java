package part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Pool provides String getItem() and void putItem(String item) methods for obtaining and returning resources. Before
 * obtaining an item in getItem(), a thread must acquire a permit from the semaphore, guaranteeing that an item is
 * available for use. When the thread has finished with the item, it calls putItem(String), which returns the item to
 * the pool and then returns a permit to the semaphore, which lets another thread acquire that item.
 * 
 * No synchronization lock is held when acquire() is called because that would prevent an item from being returned to
 * the pool. However, String getNextAvailableItem() and boolean markAsUnused(String item) are synchronized to maintain
 * pool consistency. (The semaphore encapsulates the synchronization needed to restrict access to the pool separately
 * from the synchronization needed to maintain pool consistency.)
 * 
 * D_Semaphore drives the application by creating executors and having them execute a runnable that repeatedly acquires
 * string item resources from a pool (implemented by Pool) and then returns them.
 *
 * Output </br>
 * pool-5-thread-1 acquiring Item 2 for 127ms </br>
 * pool-3-thread-1 acquiring Item 4 for 2072ms </br>
 * pool-4-thread-1 acquiring Item 3 for 1200ms </br>
 * pool-1-thread-1 acquiring Item 0 for 3623ms </br>
 * pool-6-thread-1 acquiring Item 1 for 3550ms [Notice here that thread-2 has not acquired an item yet]</br>
 * pool-5-thread-1 putting Item 2 back </br>
 * pool-2-thread-1 acquiring Item 2 for 2214ms [The thread-2 acquired the item released by thread-1 which had acquired
 * for shortest time]</br>
 * pool-4-thread-1 putting Item 3 back </br>
 * pool-5-thread-1 acquiring Item 3 for 3199ms </br>
 * pool-3-thread-1 putting Item 4 back </br>
 * pool-4-thread-1 acquiring Item 4 for 3906ms </br>
 * pool-2-thread-1 putting Item 2 back </br>
 *
 */
public class D_Semaphore {
  public static void main(String[] args) {
	final Pool pool = new Pool();
	Runnable r = new Runnable() {
	  @Override
	  public void run() {
		String name = Thread.currentThread().getName();
		String item;
		try {
		  while (true) {
			int sleepTime = (int) (Math.random() * 5000);
			System.out.printf("%s acquiring %s for %dms\n", name, item = pool.getItem(), sleepTime);
			Thread.sleep(sleepTime);
			System.out.printf("%s putting %s back\n", name, item);
			pool.putItem(item);
		  }
		} catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		}
	  }
	};
	ExecutorService[] executors = new ExecutorService[Pool.MAX_AVAILABLE + 1];
	for (int i = 0; i < executors.length; i++) {
	  executors[i] = Executors.newSingleThreadExecutor();
	  executors[i].execute(r);
	}
  }
}

final class Pool {
  public static final int MAX_AVAILABLE = 5;
  private Semaphore available = new Semaphore(MAX_AVAILABLE, true);
  private String[] items;
  private boolean used[] = new boolean[MAX_AVAILABLE];

  Pool() {
	items = new String[MAX_AVAILABLE];
	for (int i = 0; i < MAX_AVAILABLE; i++) {
	  items[i] = "Item " + i;
	}
  }

  String getItem() throws InterruptedException {
	available.acquire();
	return getNextAvailableItem();
  }

  void putItem(String item) {
	if (markAsUnused(item))
	  available.release();
  }

  private synchronized String getNextAvailableItem() {
	for (int i = 0; i < MAX_AVAILABLE; i++) {
	  if (!used[i]) {
		used[i] = true;
		return items[i];
	  }
	}
	return null;
  }

  private synchronized boolean markAsUnused(String item) {
	for (int i = 0; i < MAX_AVAILABLE; i++) {
	  if (item == items[i]) {
		if (used[i]) {
		  used[i] = false;
		  return true;
		} else
		  return false;
	  }
	}
	return false;
  }
}
