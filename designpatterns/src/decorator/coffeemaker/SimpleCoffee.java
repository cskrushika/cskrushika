package decorator.coffeemaker;

/**
 * Extension of {@link ICoffee} with simple ingredient and basic cost
 *
 */
public class SimpleCoffee implements ICoffee {

	@Override
	public double getCost() {
		return 1;
	}

	@Override
	public String getIngredients() {
		return "Coffee";
	}

}
