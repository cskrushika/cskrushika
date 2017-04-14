package decorator;

/**
 * In implementing the decorator pattern you construct a wrapper around an object by extending its behavior. The wrapper
 * will: </br>
 * <ul>
 * <li><b>Do its job before or after and</li>
 * <li>Delegate the call to the wrapped instance.</b></li>
 * </ul>
 * 
 * The client program can create different kinds of Object at runtime and they can specify the order of execution
 * too.</br>
 * </br>
 * <b>Important points</b>
 * <ul>
 * <li>Decorator pattern is helpful in providing runtime modification abilities and hence more flexible. Its easy to
 * maintain and extend when the number of choices are more.</li>
 * <li>The disadvantage of decorator pattern is that it uses a lot of similar kind of objects (decorators).</li>
 * </ul>
 */
public class DecoratorPatternTest {

	public static void main(String[] args) {
		System.out.println("Implementation 1:");
		IComponent decoratorComponent = new DecoratorA(new ComponentImplementation());
		decoratorComponent.processAction();

		System.out.println("\nImplementation 2:");
		IComponent decoratorComponent1 = new DecoratorA(new DecoratorB(new ComponentImplementation()));
		decoratorComponent1.processAction();
	}
}
