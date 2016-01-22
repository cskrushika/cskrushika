package javaexercises.strings;

public class RemoveSpacesInSentence {
	public static void main(String[] s) {
		String str = "g  eeks     for ge  eeks  ";
		char[] chars = str.toCharArray();
		int count = 0;
		int len = chars.length;
		/* If current character is non-space, then put this character at index 'count' and increment 'count' */
		for (int i = 0; i < len; i++) {
			/* single quotes indicate char and == can be used for comparison */
			if (' ' != (chars[i]))
				chars[count++] = chars[i];
		}
		for (int j = 0; j < count; j++)
			System.out.print(chars[j]);
	}
}
