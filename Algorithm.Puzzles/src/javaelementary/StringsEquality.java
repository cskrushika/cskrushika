package javaelementary;

public class StringsEquality {
	public static void main(String[] args) {
		String a1 = "hindustan";
		String b1 = "hindustan";
		System.out.printf("Strings in pool comparison: %s\n",a1==b1);
		String a2 = new String("hindustan");
		String b2 = new String("hindustan");
		System.out.printf("Strings in heap comparison: %s\n",a2==b2);
		System.out.printf("Strings in pool and heap comparison: %s\n",a1==b2);
	}
}
