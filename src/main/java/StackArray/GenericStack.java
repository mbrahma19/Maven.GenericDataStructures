package StackArray;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;


/**
 * Expand the ArrayList implementation of stack here to use an E[] array.  Still implement push, pop, and isEmpty.
 * Remember, you might need to resize the stack in the push method.
 * @param <E>
 */
public class GenericStack<E>{
    private E[] elements;

    public GenericStack() {
        elements = (E[]) new Object[0];
    }

    public boolean isEmpty() {
        return elements.length==0;
    }

    public void push(E foobar) {
        Object[] element = new Object[]{foobar};
        elements = (E[]) Stream.concat(Arrays.stream(element), Arrays.stream(elements)).toArray();
    }

    public E pop() {
        if (elements.length < 2) {
            E element = elements[0];
            elements = (E[]) Array.newInstance(elements.getClass().getComponentType(),0);
            return element;
        } else {
            E element = elements[0];
            elements = Arrays.copyOfRange(elements, 1, elements.length);
            return element;
        }
    }
}
