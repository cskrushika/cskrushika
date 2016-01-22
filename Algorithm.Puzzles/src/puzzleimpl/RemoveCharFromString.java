/**
 * Program to remove a given character from String in Java
 * 
 * - You are not allowed to use any JDK method or third party method which solves this method directly, 
 *     but you can use basic String manipulation method like indexOf(), toChar() or substring() from java.lang.String class. 
 * - Most important thing is, you must code the logic to solve the problem by yourself. 
 * - You should also write the solution using both Iterative and Recursive algorithms.
 * 
 * http://javarevisited.blogspot.com/2015/04/how-to-remove-given-character-from.html
 * */

package puzzleimpl;

public class RemoveCharFromString {

	/**
	 * An Iterative algorithm is the one which make use of loops e.g. for loop, while loop or do while loop, 
	 * Most simple solution is to iterate over String by converting into character array and check if current character is same 
	 * as given character to remove or not, if it is then ignore it otherwise add character into StringBuilder. 
	 * At the end of iteration you will have a StringBuilder with all character except the one which is asked to remove, 
	 * just convert this StringBuilder to String and your solution is ready.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n) - as extra buffer is used.
	 * 
	 * Recursive solution is better as it works for very large strings too.
	 * */
	public static String removeIterative(String string, char ch) {
		StringBuilder builder = new StringBuilder();
		char[] strAsChar = string.toCharArray();
		for (char cha : strAsChar) {
			if (cha != ch)
				builder.append(cha);
		}
		return builder.toString();
	}
	
	/**
	 * while a recursive solution should not use any loop. 
	 * Logic. use the String.indexOf(ch). If this is -1, the char is not found and hence return the string.
	 * If found, recursively concatenate the String.substring(0,index)+String.substring(index+1,string.length());
	 * 
	 * Note: substring(beginIndex,endIndex) extracts from beginIndex and endIndex-1.
	 */
	public static String removeRecursive(String string, char ch) {
		int index = string.indexOf(ch);
		if (index == -1)
			return string;
		else
			return removeRecursive(string.substring(0, index), ch) + removeRecursive(string.substring(index + 1, string.length()), ch);

	}
	
	public static void main(String[] args) {
		String string = "aaaaaabaacaaaaaaaa";
		System.out.println(removeRecursive(string, 'b'));
		System.out.println(removeIterative(string, 'b'));
	}
}
