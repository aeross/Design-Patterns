/**
 * Factory pattern
 * Factory pattern takes the responsibility of the instantiation of a class to the factory class,
 * which loosens code coupling.
 */


// Factory class
public class Factory {
    // factory method
    public Product createProduct(String type) {
        if (type.equals("ConcreteProduct1")) {
            return new ConcreteProduct1();
        } else if (type.equals("ConcreteProduct2")) {
            return new ConcreteProduct2();
        } else {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}

// Abstract product class
abstract class Product {
    public abstract void use();
}

// Concrete product classes
class ConcreteProduct1 extends Product {
    public void use() {
        System.out.println("Using ConcreteProduct1");
    }
}

class ConcreteProduct2 extends Product {
    public void use() {
        System.out.println("Using ConcreteProduct2");
    }
}

// Client code
class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();

        Product product1 = factory.createProduct("ConcreteProduct1");
        product1.use();

        Product product2 = factory.createProduct("ConcreteProduct2");
        product2.use();
    }
}