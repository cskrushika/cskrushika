package strings.lexicographicy;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/problem/algorithm/missing-alphabets-1/activity/
 *
 */
public class PendingRearrangedAlphabets {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of test cases");
		short tc = scanner.nextShort();
		while (tc-- > 0) {
			System.out.println("Enter the alphabet set");
			String alphabet = scanner.next();
			System.out.println("Enter the number of words in the dictionary");
			int noOfWords = scanner.nextInt();
			String[] dictionary = new String[noOfWords];
			System.out.println("Enter the dictionary words");
			for (int i = 0; i < noOfWords; i++) {
				dictionary[i] = scanner.next();
			}
			System.out.println();
		}
		scanner.close();
	}
}
