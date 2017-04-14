package decorator.chaining;

/**
 * This is the basic behavior to be implemented by all concrete Decorators
 *
 */
public interface IScenarioChainedActionComponent extends IScenarioActionComponent {

	public void processOwnAction();
}
