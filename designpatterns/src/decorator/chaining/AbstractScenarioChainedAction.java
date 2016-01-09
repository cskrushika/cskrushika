package decorator.chaining;

/**
 * The abstract decorator which:</br>
 * <ul>
 * <li>Has the has-a instance of {@link IScenarioActionComponent}, actionComponent</li>
 * <li>The constructor takes in the argument {@link IScenarioActionComponent} to initialize the actionComponent</li>
 * <li>Delegates the calls to getCost() and getIngredients() to the wrapped instance (actionComponent)</li>
 * </ul>
 */
public abstract class AbstractScenarioChainedAction implements IScenarioChainedActionComponent {

    /**
     * The has-a instance of {@link IScenarioActionComponent}
     */
    protected IScenarioActionComponent actionComponent;

    public AbstractScenarioChainedAction(IScenarioActionComponent actionComponent) {
	super();
	this.actionComponent = actionComponent;
    }

    @Override
    public void processScenarioActions() {
	this.actionComponent.processScenarioActions();
	this.processOwnAction();
    }
}
