package algorithms;

import java.util.Arrays;

public class Map<K, V> {

    private int size;
    private int capacity = 16;
    @SuppressWarnings("unchecked")
    private MapEntry<K, V>[] values = new MapEntry[capacity];

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                if (values[i].getKey().equals(key)) {
                    return values[i].getValue();
                }
            }
        }
        return null;
    }

    public void put(K key, V value) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i].setValue(value);
                insert = false;
            }
        }
        if (insert) {
            if (size == values.length) {
                int newSize = values.length * 2;
                values = Arrays.copyOf(values, newSize);
            }
            values[size++] = new MapEntry<K, V>(key, value);
        }
    }

    public int size() {
        return size;
    }
}
