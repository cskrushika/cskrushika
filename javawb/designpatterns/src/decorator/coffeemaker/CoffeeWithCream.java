package decorator.coffeemaker;

/**
 * A specific Decorator class which extends the Abstract decorator
 *
 */
public class CoffeeWithCream extends AbstractCoffeeDecorator {

    public CoffeeWithCream(ICoffee c) {
	super(c);
    }

    @Override
    public double getCost() {
	return super.getCost() + 0.6;
    }
    
    @Override
    public String getIngredients(){
	return super.getIngredients() + " and Cream";
    }

}
