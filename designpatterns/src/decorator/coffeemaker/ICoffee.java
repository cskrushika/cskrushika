package decorator.coffeemaker;

/**
 * This is the basic behavior to be implemented by all concrete Decorators
 *
 */
public interface ICoffee {

    public double getCost();

    public String getIngredients();

}
