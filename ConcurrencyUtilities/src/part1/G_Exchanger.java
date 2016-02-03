package part1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * One thread fills one buffer with strings while another thread empties another buffer. When the respective buffer is
 * full or empty, these threads meet at an exchange point and swap buffers.</br>
 *
 * For example, when the filling thread's currentBuffer.isFull() expression is true, it executes currentBuffer =
 * exchanger.exchange(currentBuffer) and waits. The emptying thread continues until currentBuffer.isEmpty() evaluates to
 * true, and also invokes exchange(currentBuffer). At this point, the buffers are swapped and the threads continue.</br>
 * 
 * Output:</br>
 * Adding item ITEM0 into the buffer</br>
 * Adding item ITEM1 into the buffer</br>
 * Adding item ITEM2 into the buffer</br>
 * Adding item ITEM3 into the buffer</br>
 * Adding item ITEM4 into the buffer</br>
 * Removing from buffer: ITEM0</br>
 * Removing from buffer: ITEM1</br>
 * Removing from buffer: ITEM2</br>
 * Removing from buffer: ITEM3</br>
 * Removing from buffer: ITEM4</br>
 * Adding NEWITEM0</br>
 * EmptyingLoop wants an exchange</br>
 * Adding NEWITEM1</br>
 * Adding NEWITEM2</br>
 * Adding NEWITEM3</br>
 * Adding NEWITEM4</br>
 * FillingLoop wants an exchange</br>
 * FillingLoop OBSERVES an exchange</br>
 * EmptyingLoop OBSERVES an exchange</br>
 * Removing from buffer: NEWITEM0</br>
 * Removing from buffer: NEWITEM1</br>
 * Removing from buffer: NEWITEM2</br>
 * Adding NEWITEM5</br>
 * Removing from buffer: NEWITEM3</br>
 * Removing from buffer: NEWITEM4</br>
 * EmptyingLoop wants an exchange</br>
 * Adding NEWITEM6</br>
 * Adding NEWITEM7</br>
 * Adding NEWITEM8</br>
 * Adding NEWITEM9</br>
 * FillingLoop wants an exchange</br>
 * FillingLoop OBSERVES an exchange</br>
 * EmptyingLoop OBSERVES an exchange</br>
 * Removing from buffer: NEWITEM5</br>
 * Removing from buffer: NEWITEM6</br>
 * Removing from buffer: NEWITEM7</br>
 * Removing from buffer: NEWITEM8</br>
 * Removing from buffer: NEWITEM9</br>
 * EmptyingLoop wants an exchange</br>
 */
public class G_Exchanger {
  static Exchanger<DataBuffer> exchanger = new Exchanger<DataBuffer>();
  static DataBuffer initialEmptyBuffer = new DataBuffer();
  static DataBuffer initialFullBuffer = new DataBuffer("ITEM");
  static int count = 0;

  public static void main(String[] args) {
	class FillingLoop implements Runnable {

	  @Override
	  public void run() {
		try {
		  while (true && count < 15) {
			String item = "NEWITEM" + count++;
			System.out.printf("Adding %s\n", item);
			initialEmptyBuffer.add(item);
			if (initialEmptyBuffer.isFull()) {
			  System.out.println("FillingLoop wants an exchange");
			  initialEmptyBuffer = exchanger.exchange(initialEmptyBuffer);
			  System.out.println("FillingLoop OBSERVES an exchange");

			}
		  }
		} catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		}
	  }
	}

	class EmptyingLoop implements Runnable {

	  @Override
	  public void run() {
		try {
		  while (true && count < 15) {
			System.out.printf("Removing from buffer: %s\n", initialFullBuffer.remove());
			if (initialFullBuffer.isEmpty()) {

			  System.out.println("EmptyingLoop wants an exchange");
			  initialFullBuffer = exchanger.exchange(initialFullBuffer);
			  System.out.println("EmptyingLoop OBSERVES an exchange");
			}
		  }
		} catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		}
	  }
	}

	new Thread(new EmptyingLoop()).start();
	new Thread(new FillingLoop()).start();
  }
}

class DataBuffer {
  private static final int MAX = 5;
  private List<String> items = new ArrayList<String>();

  DataBuffer() {

  }

  DataBuffer(String prefix) {
	for (int i = 0; i < MAX; i++) {
	  String item = prefix + i;
	  System.out.printf("Adding item %s into the buffer\n", item);
	  items.add(item);
	}
  }

  void add(String item) {
	if (!isFull())
	  items.add(item);
  }

  String remove() {
	if (!isEmpty())
	  return items.remove(0);
	return null;
  }

  boolean isFull() {
	return items.size() == MAX;
  }

  boolean isEmpty() {
	return items.size() == 0;
  }
}