/**
 * Given an array of integers print the missing elements that lie in range 0-99. 
 * If there are more than one missing, collate them, otherwise just print the number.
 * 
 * Note that the input array may not be sorted and may contain numbers outside the range [0-99], 
 * but only this range is to be considered for printing missing elements.
 * 
 * Expected time complexity O(n), where n is the size of the input array.
 * 
 * http://www.geeksforgeeks.org/print-missing-elements-that-lie-in-range-0-99/
 */

package puzzleimpl;

public class MissingElementsInARange {

	public static void main(String[] args) {
		/* n= */
		int[] inputArray = {88, 105, 3, 2, 200, 0, 10};
		int range = 100;
		printMissing(inputArray, range);
	}

	private static void printMissing(int[] inputArray, int range) {
		// in the boolean array all the elements are initialized to false
		boolean[] toggle = new boolean[range];
		/* Complexity: O(n) */
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < range) {
				// System.out.println(inputArray[i]);
				toggle[inputArray[i]] = true;
			}
		}
		int start = 0;
		int i = 0;
		/* Complexity: O(n) */
		while (i < range) {
			if (toggle[i] == false) {
				start = i++;
				while (i < range && toggle[i] == false) {
					i++;
				}
				if (start + 1 == i)
					System.out.format("%d\n", start);
				else
					System.out.format("%d-%d\n", start, i - 1);
			} else
				i++;
		}
	}
}
