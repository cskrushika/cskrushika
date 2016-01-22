package decorators.arithmetic.actions;

import decorators.arithmetic.ArithmeticInformationDTO;
import framework.IScenarioActionComponent;

/**
 * Extension of {@link IScenarioActionComponent} with simple ingredient and basic cost
 *
 */
public class AssignmentScenarioAction implements IScenarioActionComponent<ArithmeticInformationDTO> {

	@Override
	public ArithmeticInformationDTO processScenarioActions(ArithmeticInformationDTO scenarioInformationDto) {
		System.out.println("Performing Assignment Action. Variable = " + scenarioInformationDto.getInputNumber());
		scenarioInformationDto.setResult(scenarioInformationDto.getInputNumber());
		return scenarioInformationDto;
	}

	public void assertOwnAction(ArithmeticInformationDTO lifeCycleInformationDTO) {
		// TODO Auto-generated method stub
	}
}
