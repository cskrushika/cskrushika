/**
 * In this problem you will test your knowledge of Java loops. Given three integers a, b, and n, output the following series:

	a+20b,a+20b+21b,......,a+20b+21b+...+2n−1b
	
	Input Format
	The first line will contain the number of integers, t. Each of the next t lines will have three integers, a, b, and n.
	
	Constraints:
	0≤a,b≤50
	1≤n≤15
	
	Output Format

	Print the answer to each test case in seperate lines.

	Sample Input

	2
	0 2 10
	5 3 5
	Sample Output
	
	2 6 14 30 62 126 254 510 1022 2046
	8 14 26 50 98
	Explanation
	
	In the first case:
	
	1st term=0+1*2=2
	2nd term=0+1*2+2*2=6
	3rd term=0+1*2+2*2+4*2=14
	and so on.
 * */

package javaexercises.introduction;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlgebraicExpressionLoop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		short tc = scanner.nextShort();
		while (tc-- > 0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int n = scanner.nextInt();
			int carry = 0;						
			for(int i=0; i<n; i++) {
				double pow = b * Math.pow(2, i);
				System.out.print((int)(a + carry + pow) + " ");				
				carry += pow;
			}
			System.out.println();
		}
		scanner.close();
	}
}