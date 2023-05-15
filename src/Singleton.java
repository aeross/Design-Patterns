/**
 * Singleton pattern
 * 1. Only one instance of class
 * 2. Only one global point of access to create the instance
 */

public class Singleton {
    private static Singleton instance;

    private Singleton(){}  // private constructor to avoid other classes calling it

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}