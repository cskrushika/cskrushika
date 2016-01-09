package decorator.coffeemaker;

/**
 * A specific Decorator class which extends the Abstract decorator
 *
 */
public class CoffeeWithMilk extends AbstractCoffeeDecorator {

    public CoffeeWithMilk(ICoffee c) {
	super(c);
    }

    @Override
    public double getCost() {
	return super.getCost() + 0.5;
    }
    
    @Override
    public String getIngredients(){
	return super.getIngredients() + " and Milk";
    }

}
