package framework;

/**
 * This interface is to be implemented by the first decorator in the chain. This sets off the scenario execution.
 * @param <T>
 *
 */
public interface IScenarioActionComponent<T> {

    public T processScenarioActions(T scenarioInformationDto);
    
}
