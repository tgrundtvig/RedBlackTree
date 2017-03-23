package Interfaces;

import algorithms.RedBlackNode;


/**
 * Created by Morten on 23-03-17.
 */
public interface RedBlackTreeMap<K, V> {

    void put(K key, V value);

    V get(K key);

    int size();
}
