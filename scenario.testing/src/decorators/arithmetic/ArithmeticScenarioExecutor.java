package decorators.arithmetic;

import framework.AbstractScenarioTestsExecutor;

/**
 * This class realizes the generic parameter T to {@link ArithmeticInformationDTO}
 * Run as JUnit
 */
public class ArithmeticScenarioExecutor extends AbstractScenarioTestsExecutor<ArithmeticInformationDTO> {

	@Override
	public ArithmeticInformationDTO fetchScenarioInformationDTO() {
		ArithmeticInformationDTO informationDTO = new ArithmeticInformationDTO();
		informationDTO.setInputNumber(5);
		return informationDTO;
	}

	@Override
	protected String fetchComponentClassName(String actionName) {
		return ArithmeticScenarioComponentFactory.getInstance().fetchComponentClassName(actionName);
	}
}
