
package map;

public interface MapInterface<K, V> {
    void put(K key, V value);
    V get(K key);
    int size();
}
