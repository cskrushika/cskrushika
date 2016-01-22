package puzzleimpl.arrays;

/*Given a sorted array in which all elements appear twice (one after one) and one element appears only once. Find that element in O(log n) complexity.
 * 
 * A Simple Solution is to traverse the array from left to right. Since the array is sorted, we can easily figure out the required element.
 * 
 * An Efficient Solution can find the required element in O(Log n) time. The idea is to use Binary Search. Below is an observation in input array.
 All elements before the required have first occurrence at even index (0, 2, ..) and next occurrence at odd index (1, 3, …). And all elements after the required element have first occurrence at odd index and next occurrence at even index.

 1) Find the middle index, say ‘mid’.

 2) If ‘mid’ is even, then compare arr[mid] and arr[mid + 1]. If both are same, then the required element after ‘mid’ else before mid.

 3) If ‘mid’ is odd, then compare arr[mid] and arr[mid – 1]. If both are same, then the required element after ‘mid’ else before mid.*/
public class ElementAppearingOnceInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 3, 3, 4, 4, 5, 5, 9, 7, 7, 8, 8 };
		findSingleOccurence(arr, 0, arr.length - 1);
	}

	/* A Binary Search based function to find the element that appears only once */
	public static void findSingleOccurence(int[] arr, int low, int high) {
		// Base cases
		if (low > high)
			return;

		if (low == high) {
			System.out.println("The element occurring only once is: " + arr[low]);
			return;
		}

		int mid = (low + high) / 2;
		System.out.println(mid);
		/*
		 * If mid is even and element next to mid is same as mid, then output element lies on right side, else on left side
		 */

		if (mid % 2 == 0) {
			// if mid is even
			if (arr[mid] == arr[mid + 1]) {
				findSingleOccurence(arr, mid + 2, high);
			} else {
				findSingleOccurence(arr, low, mid);
			}
		} else {
			// if mid is odd
			if (arr[mid] == arr[mid - 1]) {
				findSingleOccurence(arr, mid + 1, high);
			} else {
				findSingleOccurence(arr, low, mid);
			}
		}
	}
}
