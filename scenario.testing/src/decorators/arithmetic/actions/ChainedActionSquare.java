package decorators.arithmetic.actions;

import decorators.arithmetic.AbstractArithmeticChainedAction;
import decorators.arithmetic.ArithmeticInformationDTO;
import framework.AbstractScenarioChainedAction;
import framework.IScenarioActionComponent;

/**
 * A specific Decorator class which extends the Abstract decorator
 *
 */
public class ChainedActionSquare extends AbstractArithmeticChainedAction {

	public ChainedActionSquare(IScenarioActionComponent c) {
		super(c);
	}

	@Override
	public ArithmeticInformationDTO processOwnAction(ArithmeticInformationDTO scenarioInformationDto) {
		System.out.println("Performing Square action");
		scenarioInformationDto.setResult(scenarioInformationDto.getResult() * scenarioInformationDto.getResult());
		return scenarioInformationDto;
	}

	@Override
	public void assertOwnAction(ArithmeticInformationDTO lifeCycleInformationDTO) {
		super.assertOwnAction(lifeCycleInformationDTO);
	}

}
