package decorator.chaining;

/**
 * A specific Decorator class which extends the Abstract decorator
 *
 */
public class ChainedActionTwo extends AbstractScenarioChainedAction {

	public ChainedActionTwo(IScenarioActionComponent c) {
		super(c);
	}

	@Override
	public void processOwnAction() {
		System.out.println("Performing Second Scenario action");

	}
}
