/**
 * You are given an array of n+2 elements. All elements of the array are in range 1 to n. 
 * And all elements occur once except two numbers which occur twice. 
 * Find the two repeating numbers.
 * 
 * For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5.
 * The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 
 * which occur twice. So the output should be 4 2.
 * 
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * */

package puzzleimpl.arrays;

public class RepeatingElementsTwo {
	
	public static void main(String[] args) {
		/* n= */
		int[] inputArray = {4, 2, 4, 5, 2, 3, 1};
		int n = 5;
		printDuplicatesAuxiliaryArray(inputArray, n);
		printDuplicatesAlgrbraic(inputArray, n);
	}

	/*
	 * Time Complexity: O(n)
	 * Auxiliary Space: O(n)
	 * Approach applicable even if there are any number of duplicate elements 
	 */
	private static void printDuplicatesAuxiliaryArray(int[] inputArray, int n) {
		boolean[] toggleArray = new boolean[n+1];
		System.out.println("Duplicate elements:");
		for(int i=0;i<n+2;i++){
			if(toggleArray[inputArray[i]]==true)
				System.out.printf("%d\n", inputArray[i]);
			else
				toggleArray[inputArray[i]] = true;
		}
	}
	
	/*
	 * Let the numbers which are being repeated are X and Y. We make two equations for X and Y and the simple task left is to solve the two equations.
	 * We know the sum of integers from 1 to n is n(n+1)/2 and product is n!. We calculate the sum of input array, when this sum is subtracted from n(n+1)/2, we get X + Y because X and Y are the two numbers missing from set [1..n]. Similarly calculate product of input array, when this product is divided from n!, we get X*Y. Given sum and product of X and Y, we can find easily out X and Y.
	 * 
	 * Let summation of all numbers in array be S and product be P
	 * 
	 * X + Y = S – n(n+1)/2
	 * XY = P/n!
	 * 
	 * Using above two equations, we can find out X and Y. For array = 4 2 4 5 2 3 1, we get S = 21 and P as 960.
	 * X + Y = 21 – 15 = 6
	 * XY = 960/5! = 8
	 * X – Y = sqrt((X+Y)^2 – 4*XY) = sqrt(4) = 2
	 * 
	 * Using below two equations, we easily get X = (6 + 2)/2 and Y = (6-2)/2
	 * X + Y = 6
	 * X – Y = 2
	 * 
	 * Time Complexity: O(n)
	 * Auxiliary Space: O(1)
	 * Note: There can be addition and multiplication overflow problem with this approach.
	 * */
	private static void printDuplicatesAlgrbraic(int[] inputArray, int n) {
		int sum=0, product=1;
		double diff=0;
		double x=0,y=0;			// two repeating numbers
		for(int i=0;i<n+2;i++){
			sum+=inputArray[i];
			product*=inputArray[i];
		}
		
		sum = sum - n*(n+1)/2;		// which is x+y
		product = product/factorial(n);		// which is x*y
		
		diff = Math.sqrt(sum*sum-4*product);
		
		x = (sum + diff)/2;
		y = (sum - diff)/2;
		
		System.out.printf("Duplicate elements: %f,%f\n", x,y);
	}
	
	public static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
