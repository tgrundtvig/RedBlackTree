package algorithms;

/**
 *
 * @author Kim
 */
public interface IRedBlackMap<K,V> {
    public void put(K key, V value);
    public V get(K key);
    public int size();
}
