package decorators.arithmetic;

import java.util.Map;

import framework.AbstractScenarioChainedAction;
import framework.IScenarioActionComponent;

/**
 * This class realizes the generic T to {@link ArithmeticInformationDTO}
 *
 */
public abstract class AbstractArithmeticChainedAction extends AbstractScenarioChainedAction<ArithmeticInformationDTO> {

	public AbstractArithmeticChainedAction(IScenarioActionComponent<ArithmeticInformationDTO> actionComponent) {
		super(actionComponent);
	}

	public AbstractArithmeticChainedAction(IScenarioActionComponent<ArithmeticInformationDTO> actionComponent,
			Map<String, String> parameters) {
		super(actionComponent, parameters);
	}

	public void assertOwnAction(ArithmeticInformationDTO lifeCycleInformationDTO) {
		// TODO Auto-generated method stub
	}

}
