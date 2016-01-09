package decorator;

/**
 * This class</br>
 * 1. Implements the Component Interface and </br>
 * 2. Has a has-a relationship with the component interface </br>
 *
 */
public class Decorator implements IComponent {

    protected IComponent component;

    public Decorator(IComponent component) {
	this.component = component;
    }

    @Override
    public void processAction() {
	this.component.processAction();
    }

}
