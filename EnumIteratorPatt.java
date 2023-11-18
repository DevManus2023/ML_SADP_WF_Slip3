/*SLIP 3:
 * Write a Java Program to implement Adapter pattern for Enumeration iterator
 */
import java.util.Enumeration;
import java.util.Iterator;

// Enumeration to Iterator Adapter
class EnumerationAdapter<T> implements Iterator<T> {
    private final Enumeration<T> enumeration;

    public EnumerationAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported for Enumeration to Iterator Adapter");
    }
}

public class EnumIteratorPatt {
    public static void main(String[] args) {
        // Creating an Enumeration (example: Vector enumeration)
        java.util.Vector<String> vector = new java.util.Vector<>();
        vector.add("Enum Iterator Item 1");
        vector.add("Enum Iterator Item 2");
        vector.add("Enum Iterator Item 3");
        Enumeration<String> enumeration = vector.elements();

        // Using the Enumeration to Iterator Adapter
        Iterator<String> iterator = new EnumerationAdapter<>(enumeration);

        // Using the adapted Iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
