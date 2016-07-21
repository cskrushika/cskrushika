package testing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Base class for all Unit tests.</br>
 * This class makes use of {@link ResourceBundle} to fetch the test data, thereby separating test data and the test
 * code.
 * 
 */
public abstract class BaseUnitTest {
	/** Resource bundle for the local test data */
	private ResourceBundle rb = null;

	public BaseUnitTest() {
		// Code to fetch test data from the properties file with same name as the class
		String className = this.getClass().getName();
		try {
			rb = ResourceBundle.getBundle(className);
//			System.out.println("The test data file name: " + className);
		} catch (MissingResourceException e) {
			System.out.println("Missing resource bundle for " + className);
		}
	}

	/**
	 * Get a property value from the respective Test class ResourceBundle file.
	 * 
	 * @param property
	 * @return
	 */
	private String getPropertyValue(final String property) {
		String value = null;
		try {
			if (rb != null) {
				value = rb.getString(property);
			}
		} catch (MissingResourceException e) {
			System.out.println("Missing resource bundle for " + this.getClass().getName() + " . Property: " + property);
		}
		return value;
	}

	protected String getStringValue(final String property) {
		return getPropertyValue(property);
	}

	protected int getIntValue(final String property) {
		return Integer.parseInt(getPropertyValue(property));
	}

	protected long getLongValue(final String property) {
		return Long.parseLong(getPropertyValue(property));
	}

	protected float getFloatValue(final String property) {
		return Float.parseFloat(getPropertyValue(property));
	}

	protected boolean getBooleanValue(final String property) {
		return Boolean.parseBoolean(getPropertyValue(property));
	}

	/**
	 * Returns Java8's {@link LocalDate} for the with the pattern "yyyy-mm-dd" as the default format.
	 * 
	 * @param property
	 * @return
	 */
	protected LocalDate getDate(final String property) {
		String strDate = getStringValue(property);
		LocalDate date = null;
		if (strDate != null && !strDate.equals("")) {
			// use Java 8 DateTime here.
			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
			date = LocalDate.parse(strDate, dtf);
		}
		return date;
	}
}
