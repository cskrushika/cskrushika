package decorator.chaining;

/**
 * A specific Decorator class which extends the Abstract decorator
 *
 */
public class ChainedActionThree extends AbstractScenarioChainedAction {

    public ChainedActionThree(IScenarioActionComponent c) {
	super(c);
    }

    @Override
    public void processOwnAction() {
	System.out.println("Performing Third Scenario action");
    }
}
