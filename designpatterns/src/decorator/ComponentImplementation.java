package decorator;

/**
 * The basic implementation of the Component Interface
 *
 */
public class ComponentImplementation implements IComponent {

    @Override
    public void processAction() {
	System.out.println("This is the basic implementation");
    }

}
