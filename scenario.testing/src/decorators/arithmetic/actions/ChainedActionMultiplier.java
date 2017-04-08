package decorators.arithmetic.actions;

import java.util.Map;

import decorators.arithmetic.AbstractArithmeticChainedAction;
import decorators.arithmetic.ArithmeticInformationDTO;
import framework.AbstractScenarioChainedAction;
import framework.IScenarioActionComponent;

/**
 * A specific Decorator class which extends the Abstract decorator</br>
 * Default multiplier = 2.
 *
 */
public class ChainedActionMultiplier extends AbstractArithmeticChainedAction {

	public ChainedActionMultiplier(IScenarioActionComponent c) {
		super(c);
	}

	public ChainedActionMultiplier(IScenarioActionComponent c, Map<String, String> params) {
		super(c, params);
	}

	@Override
	public ArithmeticInformationDTO processOwnAction(ArithmeticInformationDTO scenarioInformationDto) {
		int multiplier = 2;
		if (this.parameters != null) {
			Integer mul = Integer.valueOf(this.parameters.get("mul"));
			if (mul != null)
				multiplier = mul.intValue();
		}
		System.out.println("Performing Multiply action with multiplier: " + multiplier);
		scenarioInformationDto.setResult(scenarioInformationDto.getResult() * multiplier);
		return scenarioInformationDto;
	}

	@Override
	public void assertOwnAction(ArithmeticInformationDTO lifeCycleInformationDTO) {
		super.assertOwnAction(lifeCycleInformationDTO);
	}

}
