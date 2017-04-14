package decorator.chaining;

import java.lang.reflect.Constructor;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The test client for the execution of multiple actions (ConcreteDecorators)
 *
 */
public class ScenarioTestsExecutor {

	private static ResourceBundle rb = null;

	public static void main(String[] args) {

		ScenarioTestsExecutor main = new ScenarioTestsExecutor();
		String[] testCases = main.loadScenario(main.getClass().getName()).split(",");
		Constructor actionConstructor;
		try {
			actionConstructor = Class.forName(main.getStringValue(testCases[0])).getConstructor();
			IScenarioActionComponent previousAction = (IScenarioActionComponent) actionConstructor.newInstance(null);
			for (int i = 1; i < testCases.length; i++) {
				actionConstructor = Class.forName(main.getStringValue(testCases[i]))
						.getConstructor(IScenarioActionComponent.class);
				previousAction = (IScenarioActionComponent) actionConstructor.newInstance(previousAction);
			}
			previousAction.processScenarioActions();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String loadScenario(String className) {
		String scenario = null;
		try {
			rb = ResourceBundle.getBundle(className);
			scenario = getStringValue("Scenario");
		} catch (MissingResourceException e) {
			System.out.println("Missing resource bundle for " + className);
		}
		return scenario;
	}

	public String getPropertyValue(final String property) {
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

	private String getStringValue(final String property) {
		return getPropertyValue(property);
	}

}
