package puzzleimpl;

import java.util.Stack;

public class WordReverseWithoutTokenization {
	public static String reverse(String sentence) {
		StringBuffer buff = new StringBuffer(sentence);
		String revSentence = buff.reverse().toString();
		char[] revSentenceChars = revSentence.toCharArray();
		Stack<Character> charStack = new Stack<Character>();
		int length = revSentenceChars.length;
		int i=0;
		while(i<length){
			int prev = i;
			while( i<length && revSentenceChars[i] != ' '){
				charStack.push(revSentenceChars[i]);
				i++;
			}
			while(prev<i){
				revSentenceChars[prev] = charStack.pop();
				prev++;
			}
			i++;
		}
		return new String(revSentenceChars);
	}

	public static void main(String[] args) {
		String retval = null;
		retval = reverse("VMware from Bye Bye");
		System.out.println(retval);
	}
}