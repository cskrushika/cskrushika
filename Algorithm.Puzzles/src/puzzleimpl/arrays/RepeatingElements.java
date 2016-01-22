/**
 * Given an array of n elements which contains elements from 0 to n-1, 
 * with any of these numbers appearing any number of times. 
 * Find these repeating numbers in O(n) and using only constant memory space.
 * 
 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 * Algorithm:
 * traverse the list for i= 0 to n-1 elements
 * {
 *  check for sign of A[abs(A[i])] ;
 *  if positive then
 *     make it negative by   A[abs(A[i])]=-A[abs(A[i])];
 *  else  // i.e., A[abs(A[i])] is negative
 *     this   element (ith element of list) is a repetition
 * }
 * 
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * */

package puzzleimpl.arrays;

public class RepeatingElements {

	public static void main(String[] args) {
		/* n= */
		int[] inputArray = { 1, 2, 3, 1, 3, 6, 6 };
		printDuplicates(inputArray);
	}

	private static void printDuplicates(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			/*
			 * Math.abs() returns the absolute value of an int value. If the
			 * argument is not negative, the argument is returned. If the
			 * argument is negative, the negation of the argument is returned.
			 */
			if (inputArray[Math.abs(inputArray[i])] >= 0)
				inputArray[Math.abs(inputArray[i])] = -inputArray[Math.abs(inputArray[i])];
			else
				System.out.printf("%d\n", Math.abs(inputArray[i]));
		}
	}
}
