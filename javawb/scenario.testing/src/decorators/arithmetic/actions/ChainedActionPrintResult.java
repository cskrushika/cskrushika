package decorators.arithmetic.actions;

import decorators.arithmetic.AbstractArithmeticChainedAction;
import decorators.arithmetic.ArithmeticInformationDTO;
import framework.IScenarioActionComponent;

/**
 * A specific Decorator class which extends the Abstract decorator
 *
 */
public class ChainedActionPrintResult extends AbstractArithmeticChainedAction {

	public ChainedActionPrintResult(IScenarioActionComponent<ArithmeticInformationDTO> c) {
		super(c);
	}

	@Override
	public ArithmeticInformationDTO processOwnAction(ArithmeticInformationDTO scenarioInformationDto) {
		System.out.println("Result of Arithmetic operations: " + scenarioInformationDto.getResult());
		return scenarioInformationDto;
	}

	@Override
	public void assertOwnAction(ArithmeticInformationDTO lifeCycleInformationDTO) {
		super.assertOwnAction(lifeCycleInformationDTO);
	}

}
