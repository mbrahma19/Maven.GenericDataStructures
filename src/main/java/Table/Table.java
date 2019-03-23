package Table;

import java.util.ArrayList;

/**
 * This class needs to manage an ArrayList of Entry objects.  It needs a get method that takes a key and returns
 * its corresponding value, or null of the key is not in the arraylist.  It needs a put method that takes a key and value
 * and makes an entry with key, value.  NOTE: There cannot be two entries with the same key.
 * It also needs a remove method which takes a key and, if that key exists in the arraylist, removes that item.
 * Void return on `remove`.
 */
public class Table<K, V> {
    private ArrayList<Entry<K, V>> entries;

    public Table() {
        entries = new ArrayList<Entry<K, V>>();
    }

    public V get(K key) {
        V result = null;
        for (Entry<K, V> e : entries) {
            if (e.getKey().equals(key)) {
                result = e.getValue();
                break;
            }
        }
        return result;
    }

    public void put(K key, V value) {
        if (!contains(key)) {
            entries.add(new Entry<>(key, value));
        } else {
            remove(key);
            entries.add(new Entry<>(key, value));
        }
    }

    public void remove(K key) {
        Entry<K, V> result = null;
        if (contains(key)) {
            for (Entry<K, V> e : entries) {
                if (e.getKey().equals(key)) {
                    result = e;
                }
            }
            entries.remove(result);
        }
    }

    private boolean contains(K key) {
        boolean result = false;
        for (Entry e : entries) {
            if (e.getKey().equals(key)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
