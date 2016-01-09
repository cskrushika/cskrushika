package decorator;

/**
 * This is a concrete {@link Decorator} which extends the Decorator and enhances the functions of the Decorator
 * accordingly
 *
 */
public class DecoratorB extends Decorator {

    public DecoratorB(IComponent component) {
	super(component);
    }

    @Override
    public void processAction() {
	component.processAction();
	System.out.println("B's decoration");
	doBSpecific();
    }

    public void doBSpecific() {
	System.out.println("B-specific actions");
    }

}
