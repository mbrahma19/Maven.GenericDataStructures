package TableNested;

import java.util.ArrayList;

/**
 * All you need to do for this microlab is take the Table and Entry from the last one and make Entry a nested class.
 * Think about how nested classes should work with generics.
 */
public class TableNested<K, V> {

    private ArrayList<Entry<K, V>> entries;

    public TableNested() {
        entries = new ArrayList<>();
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

    class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }
}
