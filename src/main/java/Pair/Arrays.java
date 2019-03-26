package Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Optional;

/**
 * In here you must make firstLast, which will return a pair of the first element in the array list and the last
 * element in the arraylist.
 * You must also make a min method that returns the smallest item in the array list
 * A max method that returns the largest item in the arraylist
 * And a minmax method that returns a pair containing the largest and smallest items from the array list
 */
public class Arrays{

    public static<E extends Comparable> Pair<E> firstLast(ArrayList<E> a) {
        return new Pair<>(a.get(0),a.get(a.size()-1));
    }
    public static<E extends Comparable<E>> E max(ArrayList<E> al) {
        return Collections.max(al);
    }

    public static<E extends Comparable<E>> E min(ArrayList<E> al){
//        return al.stream().min(Comparator.naturalOrder()).orElse(null);
        return Collections.min(al);
    }

    public static<E extends Comparable<E>> Pair minMax(ArrayList<E> al) {
        return new Pair<>(min(al),max(al));
    }
}
