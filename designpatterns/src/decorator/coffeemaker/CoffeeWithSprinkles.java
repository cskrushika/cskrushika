package decorator.coffeemaker;

/**
 * A specific Decorator class which extends the Abstract decorator
 *
 */
public class CoffeeWithSprinkles extends AbstractCoffeeDecorator {

    public CoffeeWithSprinkles(ICoffee c) {
	super(c);
    }

    @Override
    public double getCost() {
	return super.getCost() + 0.2;
    }
    
    @Override
    public String getIngredients(){
	return super.getIngredients() + " and Sprinkles";
    }

}
