/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapImplementation;

import java.util.Arrays;

/**
 *
 * @author CosticaTeodor
 * @param <K>
 * @param <V>
 */
public class MyMap<K, V> {

    private int size;
    private int DEFAULT_CAPACITY = 16;
    private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];

    public V get(K key) {//get(4) example
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
            ensureCapa();
            values[size++] = new MyEntry<K, V>(key, value);
        }
    }

    public void remove(K key) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    public int size() {
        return size;
    }

    private void ensureCapa() {
        if (size() == values.length) {
            int newSize = size() * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    private void condenseArray(int start) {
        for (int i = start; i < size; i++) {
            values[i] = values[i + 1];
        }
    }

}
