package creational;

import java.util.ArrayList;
import java.util.List;

interface Ingredient {
    String name();
}

interface Cheese extends Ingredient {}

class GoatCheese implements Cheese {

    @Override
    public String name() {
        return "Goat Cheese";
    }
}

class FetaCheese implements Cheese {

    @Override
    public String name() {
        return "Feta Cheese";
    }
}

interface Sauce extends Ingredient {}

class MexicanSauce implements Sauce {
    @Override
    public String name() {
        return "Mexican Sauce";
    }
}

class TurkishSauce implements Sauce {
    @Override
    public String name() {
        return "Turkish Sauce";
    }
}

abstract class Topping {
    abstract Cheese getCheese();
    abstract Sauce getSauce();
    List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(getCheese());
        ingredients.add(getSauce());
        return ingredients;
    }
}

class StandardTopping extends Topping {

    @Override
    Cheese getCheese() {
        return null;
    }

    @Override
    Sauce getSauce() {
        return null;
    }

    @Override
    List<Ingredient> getIngredients(){
        return null;
    }
}

class MexicanTopping extends Topping {

    @Override
    Cheese getCheese() {
        return new GoatCheese();
    }

    @Override
    Sauce getSauce() {
        return new MexicanSauce();
    }
}

class TurkishTopping extends Topping {

    @Override
    Cheese getCheese() {
        return new FetaCheese();
    }

    @Override
    Sauce getSauce() {
        return new TurkishSauce();
    }
}

abstract class Pizza {
    List<Ingredient> extraIngredients;

    public Pizza(List<Ingredient> extraIngredients){
        this.extraIngredients = extraIngredients;
    }

    public Pizza() {}

    abstract void bake();
}

class CheesePizza extends Pizza {

    public CheesePizza(List<Ingredient> extraIngredients){
        super(extraIngredients);
    }

    public CheesePizza(){}

    @Override
    void bake() {
        if (extraIngredients != null) {
            extraIngredients.stream().map(Ingredient::name).forEach(System.out::println);
        }
        System.out.println("I am a cheese pizza");
    }
}

class PepperoniPizza extends Pizza {

    public PepperoniPizza(List<Ingredient> extraIngredients){
        super(extraIngredients);
    }

    public PepperoniPizza(){}

    @Override
    void bake() {
        if (extraIngredients != null) {
            extraIngredients.stream().map(Ingredient::name).forEach(System.out::println);
        }
        System.out.println("I am a pepperoni pizza");
    }
}

class VegetarianPizza extends  Pizza {

    public VegetarianPizza(List<Ingredient> extraIngredients){
        super(extraIngredients);
    }

    public VegetarianPizza(){}

    @Override
    void bake() {
        if (extraIngredients != null) {
            extraIngredients.stream().map(Ingredient::name).forEach(System.out::println);
        }
        System.out.println("I am a vegetarian pizza");
    }
}

class PizzaFactory {
    static Pizza getPizza (String type, Topping topping) {
        List<Ingredient> ingredients = topping.getIngredients();
        Pizza pizza;
        switch (type.toLowerCase()){
            case "cheese":
                pizza = new CheesePizza(ingredients);
                break;
            case "pepperoni":
                pizza = new PepperoniPizza(ingredients);
                break;
            case "veggie":
                pizza = new VegetarianPizza(ingredients);
                break;
            default: throw new IllegalArgumentException("No such pizza.");
        }
        pizza.bake();
        return pizza;
    }
}

class ToppingFactory {
    static Topping getTopping(String type) {
        switch (type.toLowerCase()){
            case "standard":
                return new StandardTopping();
            case "mexican":
                return new MexicanTopping();
            case "turkish":
                return new TurkishTopping();
            default: throw new IllegalArgumentException("No such topping.");
        }
    }
}

public class AbstractFactory {
    public static void main(String[] args) {

        System.out.println("========");
        Pizza pizza1 = PizzaFactory.getPizza("veggie", ToppingFactory.getTopping("standard"));
        System.out.println("========");
        Pizza pizza2 = PizzaFactory.getPizza("cheese", ToppingFactory.getTopping("mexican"));
        System.out.println("========");
        Pizza pizza3 = PizzaFactory.getPizza("pepperoni", ToppingFactory.getTopping("turkish"));
        System.out.println("========");
    }
}
