/**
 * Problem Statement
Java has 8 Primitive Data Types; they are char, boolean, byte, short, int, long, float, and double. In this problem we are only concerned about integer datatypes used to hold integer values (byte, short, int, long). Let's tae a closer look at them:
	byte data type is an 8-bit signed integer.
	short data type is an 16-bit signed integer.
	int data type is an 32-bit signed integer.
	long data type is an 64-bit signed integer.
Given an integer number, you have to determine which of these datatypes you can use to store that number. If there are multiple suitable datatypes, list them all in the order above.

Input Format

The first line will contain an integer T. Each of the next T lines will contain an integer n. The number can be arbitrarily large or small!

Output Format

For each n, list all the datatypes it can be fitted into ordered by the size of the datatype. If it can't be fitted into any of these datatypes, print "n can't be fitted anywhere." See the sample output for the exact formatting.

Sample Input

-150
150000
1500000000
Sample Output

-150 can be fitted in:
 * short
 * int
 * long
150000 can be fitted in:
 * int
 * long
1500000000 can be fitted in:
 * int
 * long
213333333333333333333333333333333333 can't be fitted anywhere.
-100000000000000 can be fitted in:
 * long
 * */

package javaexercises.introduction;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IntegerRangeCheck {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int tcCount = scanner.nextInt();
		Long num;
		String str = "";		
		while (tcCount-- >= 1) {
			try {
				str = scanner.next();
				long l = Long.valueOf(str);
				System.out.println(l + " can be fitted in:");
				if (l == 0 || l == 1) {
					System.out.println("* boolean");
				}
				if (Byte.MAX_VALUE >= l && Byte.MIN_VALUE <= l) {
					System.out.println("* byte");
				}
				if (Short.MAX_VALUE >= l && Short.MIN_VALUE <= l) {
					System.out.println("* short");
				}
				if (Integer.MAX_VALUE >= l && Integer.MIN_VALUE <= l) {
					System.out.println("* int");
				}
				if (Long.MAX_VALUE >= l && Long.MIN_VALUE <= l) {
					System.out.println("* long");
				}
			} catch (Exception e) {
				System.out.println(str + " can't be fitted anywhere.");
			}

		}
	}
}