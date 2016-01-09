package decorator;

/**
 * This is a concrete {@link Decorator} which extends the Decorator and enhances the functions of the Decorator
 * accordingly
 *
 */
public class DecoratorA extends Decorator {

    public DecoratorA(IComponent component) {
	super(component);
    }

    @Override
    public void processAction() {
	component.processAction();
	System.out.println("A's decoration");
	doASpecific();
    }
    
    public void doASpecific(){
	System.out.println("A-specific actions");
    }

}
