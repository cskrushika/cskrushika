package framework;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import decorators.arithmetic.ArithmeticScenarioComponentFactory;

/**
 * The test client for the execution of multiple actions (ConcreteDecorators)
 * @param <T>
 *
 */
public abstract class AbstractScenarioTestsExecutor<T> extends BaseUnitTest {

	protected T scenarioInformationDTO;

	public AbstractScenarioTestsExecutor() {
		super();
	}

	@Test
	public void executeScenario() {
		List<String> cases = getData();
		for (String scenarioCase : cases) {
			String[] testCases = scenarioCase.split(",");
			Constructor<?> actionConstructor;
			try {
				ScenarioActionParameter scenarioActionParameter = interpret(testCases[1]);
				String componentClass = ArithmeticScenarioComponentFactory.getInstance().fetchComponentClassName(scenarioActionParameter.actionName);
				actionConstructor = Class.forName(componentClass).getConstructor();
				IScenarioActionComponent previousAction = (IScenarioActionComponent) actionConstructor.newInstance(null);
				for (int i = 2; i < testCases.length; i++) {
					scenarioActionParameter = interpret(testCases[i]);
					componentClass = fetchComponentClassName(scenarioActionParameter.actionName);
					if (scenarioActionParameter.map.size() > 0) {
						actionConstructor = Class.forName(componentClass).getConstructor(IScenarioActionComponent.class, Map.class);
						previousAction = (IScenarioActionComponent) actionConstructor.newInstance(previousAction,
								scenarioActionParameter.map);
					} else {
						actionConstructor = Class.forName(componentClass).getConstructor(IScenarioActionComponent.class);
						previousAction = (IScenarioActionComponent) actionConstructor.newInstance(previousAction);
					}
				}
				System.out.println("####################################################################################################");
				System.out.println("Executing " + testCases[0] + " with the Cases ===== >  " + scenarioCase);
				System.out.println();
				T scenarioInformationDTO = fetchScenarioInformationDTO();
				scenarioInformationDTO = (T) previousAction.processScenarioActions(scenarioInformationDTO);
//				System.out.println("Result of scenario: " + scenarioInformationDTO.getResult());
				System.out.println();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * The implementing subclass will have supply an instance of either {@link ILifeCycleActionComponent} or
	 * {@link ILifeCycleChainedActionComponent} that corresponds the given short action name
	 * 
	 * @param actionName
	 * @return
	 */
	protected abstract String fetchComponentClassName(String actionName);

	protected abstract T fetchScenarioInformationDTO();

	/**
	 * Returns a list of scenarios. Each scenario contains its action list.
	 * 
	 * @return
	 */
	public List<String> getData() {
		String casesToRun = getStringValue("Cases");
		String[] cases = casesToRun.split(",");
		ArrayList<String> dataList = new ArrayList<String>();
		for (String testCase : cases) {
			String actions = getStringValue(testCase.trim());
			if (actions != null && actions.trim().length() != 0) {
				dataList.add(testCase.trim() + "," + actions);
			} else {
				System.err.println("No actions defined for testcase: " + testCase);
			}
		}
		return dataList;
	}

	/**
	 * This method takes a given action string and extracts the action and the key-value parameters for the action and
	 * returns a {@link ScenarioActionParameter} object.
	 * 
	 * @param actionString
	 * @return
	 */
	private ScenarioActionParameter interpret(String actionString) {
		String[] scenarioParams = actionString.split("\\(");
		ScenarioActionParameter scenarioActionParameter = new ScenarioActionParameter();
		scenarioActionParameter.actionName = scenarioParams[0];
		if (scenarioParams.length > 1) {
			scenarioParams[1] = scenarioParams[1].replaceAll("\\)", "");
			String[] keyValuePairs = scenarioParams[1].split(";");
			for (String keyValuePair : keyValuePairs) {
				String[] keyValue = keyValuePair.split("=");
				scenarioActionParameter.map.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : null);
			}
		}
		return scenarioActionParameter;
	}
}

/**
 * Represents a scenario action and its execution parameters
 *
 */
class ScenarioActionParameter {
	String actionName;
	Map<String, String> map = new HashMap<String, String>();
}
