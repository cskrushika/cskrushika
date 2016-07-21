package puzzleimpl.arrays;

/*
 * The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four sections:

a[1..Lo-1] zeroes (red)
a[Lo..Mid-] ones (white)
a[Mid..Hi] unknown
a[Hi+1..N] twos (blue)
The unknown region is shrunk while maintaining these conditions

Lo := 1; Mid := 1; Hi := N;
while Mid <= Hi do
	Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
		case a[Mid] in
			0: swap a[Lo] and a[Mid]; Lo++; Mid++
			1: Mid++
			2: swap a[Mid] and a[Hi]; Hi–
			
			http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
*/
public class DutchNationalFlag {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		seggregateArray(arr);
	}

	public static void seggregateArray(int[] arr) {
		int low = 0, mid = 0, high = arr.length - 1;

		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low++, mid++);
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + ",");
				}
				System.out.println();

				break;
			case 1:
				mid++;
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + ",");
				}
				System.out.println();

				break;
			case 2:
				/*
				 * Here mid is not incremented as arr[mid] is swapped with arr[high]. 
				 * Since arr[high] can be either 0,1,2 mid is not incremented and the
				 * swapped element is again evaluated in next iteration.
				 */
				swap(arr, mid, high--);
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + ",");
				}
				System.out.println();
				break;
			}
		}

	}

	public static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
}
