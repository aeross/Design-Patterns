import java.util.HashMap;
import java.util.Scanner;

/**
 * Strategy pattern
 * Defines a family of algorithms, encapsulate each one, and allow the clients to select
 * the algorithm to be used as a parameter.
 * The strategy pattern is useful when we have multiple algorithms for specific task, and
 * we want our application to be flexible to choose any of the algorithm at runtime for specific task.
 */

// as an example, we want to apply a discount policy for a restaurant.
// Relatives get a 99% discount, members get a 10% discount, and regular customers pay full price.
public interface Strategy {
    double applyDiscount(double amount);
}

class RelativeDiscounter implements Strategy {
    @Override
    public double applyDiscount(double amount) {
        return (1 - 0.99) * amount;
    }
}

class MemberDiscounter implements Strategy {
    @Override
    public double applyDiscount(double amount) {
        return (1 - 0.1) * amount;
    }
}

class RegularDiscounter implements Strategy {
    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}

// the context class
class Restaurant {
    private HashMap<String, Integer> items = new HashMap<>();
    private Strategy discount;

    public Restaurant() {
        items.put("water", 10);
        items.put("milk", 15);
        items.put("beer", 20);
        items.put("soda", 20);
        items.put("wine", 69);
    }

    // The method that chooses which subclass to instantiate.
    // This is also known as a factory method. Check out Factory.java for more explanation.
    public void setDiscount(String discount) {
        if (discount.equals("regular")) {
            this.discount = new RegularDiscounter();
        } else if (discount.equals("member")) {
            this.discount = new MemberDiscounter();
        } else if (discount.equals("relative")) {
            this.discount = new RelativeDiscounter();
        } else {
            throw new IllegalArgumentException("Invalid customer type");
        }
    }

    public double getFinalPrice(String item) {
        int price = items.get(item);
        return discount.applyDiscount(price);
    }
}

// client code
class Customer {
    public static void main(String[] args) {
        Restaurant kfc = new Restaurant();

        Scanner s = new Scanner(System.in);
        System.out.println("What kind of customer are you? (regular / member / relative)");
        String customerType = s.nextLine();
        kfc.setDiscount(customerType);

        System.out.println("What kind of drink would you like? (water / milk / beer / soda / wine)");
        String drinkType = s.nextLine();
        double price = kfc.getFinalPrice(drinkType);

        System.out.println("That will be $" + price + " dollars.");
    }
}
