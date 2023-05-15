import java.util.ArrayList;

/**
 * Observer pattern
 * Defines a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically.
 * In other words, observer pattern decouples the subject and observers using a
 * publish-subscribe style communication pattern.
 */

public abstract class Observer {
    public abstract void update();
}

class Observer1 extends Observer {
    private String id;

    public Observer1(String id) {
        this.id = id;
    }
    @Override
    public void update() {
        System.out.println(this.id + " is notified.");
    }
}

class Observer2 extends Observer {
    @Override
    public void update() {
        System.out.println("Observer2 is notified.");
    }
}

class Subject {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    // client code
    public static void main(String[] args) {
        Subject s = new Subject();
        Observer1 a = new Observer1("a");
        Observer1 b = new Observer1("b");
        Observer2 c = new Observer2();

        s.registerObserver(a);
        s.registerObserver(b);
        s.registerObserver(c);
        s.notifyObservers();

        s.unregisterObserver(b);
        s.notifyObservers();
    }
}