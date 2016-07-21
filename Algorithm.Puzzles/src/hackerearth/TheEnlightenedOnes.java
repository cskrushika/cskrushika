package hackerearth;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/problem/algorithm/the-enlightened-ones/
 *
 */
public class TheEnlightenedOnes {

	public static void main(String args[]) throws Exception {

		Scanner scanner = new Scanner(System.in);
		short noOfTemples = scanner.nextShort();
		short monks = scanner.nextShort();
		short templeAxisPosition[] = new short[noOfTemples];
		for (int i = 0; i < noOfTemples; i++) {
			templeAxisPosition[i] = scanner.nextShort();
		}
		int min = 99999999;
		int max = 0;
		for (int i = 0; i < noOfTemples; i++) {
			min = templeAxisPosition[i] < min ? templeAxisPosition[i] : min;
			max = templeAxisPosition[i] > max ? templeAxisPosition[i] : max;
		}
		System.out.println(max + " " + min + " " + monks);
		System.out.println((max - min) / monks);
	}
}
