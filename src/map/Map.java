
package map;

import java.util.Arrays;

public class Map<K, V> implements MapInterface<K, V>{
   
    
    private int size;
    private int arraySize = 10;
    private Node<K, V>[] values = new Node[arraySize];

    @Override
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
            values[size++] = new Node<K, V>(key, value);
        }
    }

    @Override
    public V get(K key) {
        
        for(int i = 0; i < size; i++) {
            if (values[i] != null) {
                if (values[i].getKey().equals(key)) {
                     return values[i].getValue();    
                }
            }
        }
        return null;
    }
    
    public boolean isEmpty () {
        System.out.println("Is null?: ");
        System.out.println(size() == 0);
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }
  
}
