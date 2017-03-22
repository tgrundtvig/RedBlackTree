package mymap;

/**
 *
 * @author Vixo
 */
public interface IMyMap<K, V> {
    void put(K key, V value);
    V get(K key);
    int size();
}
