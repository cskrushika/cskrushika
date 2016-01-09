package decorator.coffeemaker;

/**
 * The test class for the Coffee maker which implements the Decorator Pattern
 *
 */
public class CoffeeMaker {

    public static void main(String[] args) {
	ICoffee coffee = new SimpleCoffee();
	printInfo(coffee);
	
	coffee = new CoffeeWithSprinkles(new SimpleCoffee());
	printInfo(coffee);

	coffee = new CoffeeWithMilk(new SimpleCoffee());
	printInfo(coffee);

	coffee = new CoffeeWithMilk(new CoffeeWithSprinkles(new SimpleCoffee()));
	printInfo(coffee);
	
	coffee = new CoffeeWithCream(new CoffeeWithMilk(new CoffeeWithSprinkles(new SimpleCoffee())));
	printInfo(coffee);
    }

    private static void printInfo(ICoffee coffee) {
	System.out.println("Ingredients: " + coffee.getIngredients() + ". Cost: " + coffee.getCost());
    }

}
