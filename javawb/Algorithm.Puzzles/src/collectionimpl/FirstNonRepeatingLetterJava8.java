package collectionimpl;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://gist.github.com/mwanji/8180516
 */
public class FirstNonRepeatingLetterJava8 {
	public FirstNonRepeatingLetterJava8() {
		super();
	}

	public static void main(String[] args) {
		System.out.println("Enter the word");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		findFirstNonRepeatingCharacter(s, System.out::println);
		sc.close();
	}

	private static void findFirstNonRepeatingCharacter(String s, Consumer<Character> callback) {
		s.chars().mapToObj(i -> Character.valueOf((char) i))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.map(c -> {
					callback.accept(c);
					return c;
				});
	}
}
