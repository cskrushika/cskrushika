package decorator.chaining;

/**
 * Extension of {@link IScenarioActionComponent} with simple ingredient and basic cost
 *
 */
public class FirstScenarioAction implements IScenarioActionComponent {

    @Override
    public void processScenarioActions() {
	System.out.println("Performing First Scenario Action");
    }

}
