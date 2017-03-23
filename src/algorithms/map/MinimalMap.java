package cphbusiness.algorithms.ex.redblacktree.map;

public interface MinimalMap<K, V> {

	void put(K key, V value);

	V get(K key);

	int size();
}
