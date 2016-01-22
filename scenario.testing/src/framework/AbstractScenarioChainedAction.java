package framework;

import java.util.Map;

import decorators.arithmetic.ArithmeticInformationDTO;

/**
 * The abstract decorator which:</br>
 * <ul>
 * <li>Has the has-a instance of {@link IScenarioActionComponent}, actionComponent</li>
 * <li>The constructor takes in the argument {@link IScenarioActionComponent} to initialize the actionComponent</li>
 * <li>Delegates the calls to getCost() and getIngredients() to the wrapped instance (actionComponent)</li>
 * </ul>
 * @param <T>
 */
public abstract class AbstractScenarioChainedAction<T> implements IScenarioChainedActionComponent<T>{

	/**
	 * The has-a instance of {@link IScenarioActionComponent}
	 */
	protected IScenarioActionComponent<T> actionComponent;

	/**
	 * A map of string based key-value parameter pairs that is passed as arguments to the scenarios
	 */
	protected Map<String, String> parameters;

	public AbstractScenarioChainedAction(IScenarioActionComponent<T> actionComponent) {
		super();
		this.actionComponent = actionComponent;
	}
	
	public AbstractScenarioChainedAction(IScenarioActionComponent<T> actionComponent, Map<String, String> parameters) {
		super();
		this.actionComponent = actionComponent;
		this.parameters = parameters;
	}

	@Override
	public T processScenarioActions(T scenarioInformationDto) {
		scenarioInformationDto = this.actionComponent.processScenarioActions(scenarioInformationDto);
//		System.out.println("=============================================================================");
//		System.out.println("Starting scenario ---> "+this.getClass());
		scenarioInformationDto = this.processOwnAction(scenarioInformationDto);
//		System.out.println("Ending scenario ---> "+this.getClass());
		
		return scenarioInformationDto;
	}
}
