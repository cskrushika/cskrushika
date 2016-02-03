package part1;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * During each iteration, an attempt is made to add a new employee name to the list. The ArrayList iteration fails with
 * ConcurrentModificationException exception, whereas the CopyOnWriteArrayList iteration ignores the addition.</br>
 * </br>
 *
 * Output:</br>
 * A</br>
 * Attempt to modify list during iteration</br>
 * A</br>
 * AB</br>
 * ABC</br>
 */
public class I_ConcurrentCollection {
  public static void main(String[] args) {
	List<String> empList = new ArrayList<>();
	empList.add("A");
	empList.add("AB");
	empList.add("ABC");
	Iterator iter = empList.iterator();
	while (iter.hasNext()) {
	  try {
		System.out.println(iter.next());
		if (!empList.contains("ABCD")) {
		  empList.add("ABCD");
		}
	  } catch (ConcurrentModificationException c) {
		System.err.println("Attempt to modify list during iteration");
		break;
	  }
	}
	List<String> empList2 = new CopyOnWriteArrayList<>();
	empList2.add("A");
	empList2.add("AB");
	empList2.add("ABC");
	iter = empList2.iterator();
	while (iter.hasNext()) {
	  System.out.println(iter.next());
	  if (!empList2.contains("ABCD"))
		empList2.add("ABCD");
	}
  }
}
