/**
 * Template method:
 * Defines the steps for all subclasses that share common steps/implementations.
 * For example, making a sandwich involves adding meat, adding cheese, adding veggies, and finally,
 * wrapping the bun. Many types of sandwiches share those common steps, hence template
 * method can be used.
 * The template method pattern is useful when you want to define an algorithm that should
 * have a fixed structure but allow for some variations in certain steps.
 */

// let's do a template for bubble sort
public abstract class Template {
    private static int operations = 0;
    protected int length = 0;

    // this is the template method
    protected int doSort() {
        operations = 0;
        if (length <= 1)
            return operations;
        for (int i = length - 2; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                if (outOfOrder(j)) swap(j);
                operations++;
            }
        }
        return operations;
    }

    // non-general methods to be implemented by subclasses -- these are called hook methods
    protected abstract void swap(int i);
    protected abstract boolean outOfOrder(int i);
}

// two subclasses that uses the template method
class IntBubbleSorter extends Template {
    private int[] array = null;

    public int sort(int[] a) {
        array = a;
        length = array.length;
        return doSort();
    }

    @Override
    protected boolean outOfOrder(int index) {
        return (array[index] > array[index+1]);
    }

    @Override
    protected void swap(int index) {
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }
}

class DoubleBubbleSorter extends Template {
    private double[] array = null;

    public double sort(double[] a) {
        array = a;
        length = array.length;
        return doSort();
    }

    @Override
    protected boolean outOfOrder(int index) {
        return (array[index] > array[index+1]);
    }

    @Override
    protected void swap(int index) {
        double temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }
}