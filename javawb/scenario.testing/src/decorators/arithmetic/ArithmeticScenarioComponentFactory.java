package decorators.arithmetic;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Fetches the fully qualified class names for the Arithmetic actions
 *
 */
public class ArithmeticScenarioComponentFactory {

	private ResourceBundle rb = null;

	private static ArithmeticScenarioComponentFactory uniqueInstance = null;

	private ArithmeticScenarioComponentFactory() {
		String className = this.getClass().getName();
		try {
			rb = ResourceBundle.getBundle(className);
		} catch (MissingResourceException mre) {
			System.out.println("Missing resource bundle for " + className);
			System.out.println(mre);
		}
	}

	public static ArithmeticScenarioComponentFactory getInstance() {
		if (uniqueInstance == null) {
			synchronized (ArithmeticScenarioComponentFactory.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new ArithmeticScenarioComponentFactory();
				}
			}
		}
		return uniqueInstance;
	}

	public String fetchComponentClassName(String name) {
		if (rb.containsKey(name)) {
			return rb.getString(name);
		} else {
			System.out.println("Action class not found for: " + name);
		}
		return null;
	}
}
