package decorator.chaining;

/**
 * A specific Decorator class which extends the Abstract decorator
 *
 */
public class ChainedActionFour extends AbstractScenarioChainedAction {

    public ChainedActionFour(IScenarioActionComponent c) {
	super(c);
    }

    @Override
    public void processOwnAction() {
	System.out.println("Performing Fourth Scenario action");
    }
}
