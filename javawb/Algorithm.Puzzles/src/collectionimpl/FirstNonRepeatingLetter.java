package collectionimpl;

import java.util.HashMap;

public class FirstNonRepeatingLetter {
	private static Character firstNonRepeatedChar(String s) {
		HashMap<Character, Integer> charHashTable = new HashMap<Character, Integer>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			Character c = s.charAt(i);
			if (charHashTable.containsKey(c)) {
				charHashTable.put(c, charHashTable.get(c) + 1);
			} else {
				charHashTable.put(c, 1);
			}
		}
		for (int i = 0; i < length; i++) {
			Character c = s.charAt(i);
			if (charHashTable.get(c) == 1)
				return c;
		}
		return null;
	}
}
