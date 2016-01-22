package strings;

public class StringUtil {

	public String capitalizeFirstChar(String key) {
		String keyAsGetter = key.substring(0, 1).toUpperCase() + key.substring(1);
		return keyAsGetter;
	}

	public String getGetterString(String key) {
		String keyAsGetter = "get" + key.substring(0, 1).toUpperCase() + key.substring(1);
		return keyAsGetter;
	}

	public String prefixZeroToInteger(int n) {
		// use Math.log10+1 to extract no of digits
		int noOfDigitsInInt = (int) (Math.log10(n) + 1);
		// a prefix of 0 means add one to no of digits
		int padding = noOfDigitsInInt + 1;
		return String.format("%0" + padding + "d", n);
	}

}
