package puzzleimpl.arrays;

/**
 * Given an unsorted array, find the largest pair sum in it. For example, the largest pair sum in {12, 34, 10, 6, 40} is 74 Difficulty Level: Rookie
 * Expected Time Complexity: O(n) [Only one traversal of array is allowed]
 *
 *This problem mainly boils down to finding the largest and second largest element in array. 
 */
public class LargestPairSumInUnsortedArray {

	public static void main(String[] s) {
		int[] array = { 12, 34, 10, 6, 40 };
		int first = 0, second = 0;
		if (array[0] > array[1]) {
			first = array[0];
			second = array[1];
		} else {
			first = array[1];
			second = array[2];
		}
		for (int i = 2; i < array.length; i++) {
			if (array[i] > first) {
				second = first;
				first = array[i];
			} else if (array[i] > second && array[i] != first)
				second = array[i];
		}
		System.out.println("Largest pariwise sum: " + (first + second));
	}
}
