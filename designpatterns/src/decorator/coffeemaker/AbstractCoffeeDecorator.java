package decorator.coffeemaker;

/**
 * The abstract decorator which:</br>
 * <ul>
 * <li>Has the has-a instance of {@link ICoffee}, decoratedCoffee</li>
 * <li>The constructor takes in the argument {@link ICoffee} to initialize the decoratedCoffee</li>
 * <li>Delegates the calls to getCost() and getIngredients() to the wrapped instance (decoratedCoffee)</li>
 * </ul>
 */
public abstract class AbstractCoffeeDecorator implements ICoffee {

	/**
	 * The has-a instance of {@link ICoffee}
	 */
	protected ICoffee decoratedCoffee;

	public AbstractCoffeeDecorator(ICoffee coffee) {
		this.decoratedCoffee = coffee;
	}

	@Override
	public double getCost() {
		return this.decoratedCoffee.getCost();
	}

	@Override
	public String getIngredients() {
		return this.decoratedCoffee.getIngredients();
	}

}
