package StackArray;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Expand the ArrayList implementation of stack here to use an Object[] array.  Still implement push, pop, and isEmpty.
 * Remember, you might need to resize the stack in the push method.
 *
 * @param <E>
 */
public class ObjectStack<E> {
    private Object[] elements;

    public ObjectStack() {
        elements = new Object[0];
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    public void push(E foobar) {
        Object[] element = new Object[]{foobar};
        elements = Stream.concat(Arrays.stream(element), Arrays.stream(elements)).toArray();
    }

    public E pop() throws IndexOutOfBoundsException {
        if (elements.length < 2) {
            Object element = elements[0];
            elements = new Object[0];
            return (E) element;
        } else {
            Object element = elements[0];
            elements = Arrays.copyOfRange(elements, 1, elements.length);
            return (E) element;
        }
    }
}
