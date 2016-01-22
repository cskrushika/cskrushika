package framework;

/**
 * This is the basic behavior to be implemented by all concrete Decorators
 * @param <T>
 *
 */
public interface IScenarioChainedActionComponent<T> extends IScenarioActionComponent<T>{

    public T processOwnAction(T scenarioInformationDto);
}
