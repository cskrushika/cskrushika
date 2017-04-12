package dynamic.programming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified/
 *
 */
public class ModifiedFibonacci8 {
	static int a, b, N;
	static BigInteger[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		N = sc.nextInt();
		nums = new BigInteger[N];
		System.out.println(findNthNum(N));

	}

	private static BigInteger findNthNum(int N) {
		// IMP: to avoid recalculation. Even without this statement it works
		// fine, but the while squaring the number, each time the array cell is
		// computed
		if (nums[N] != null)
			return nums[N];
		if (N == 1)
			return BigInteger.valueOf(a);
		if (N == 2)
			return BigInteger.valueOf(b);
		nums[0] = new BigInteger(String.valueOf(a));
		nums[1] = new BigInteger(String.valueOf(b));
		return nums[N - 1] = findNthNum(N - 1).multiply(findNthNum(N - 1)).add(findNthNum(N - 2));
	}
}
