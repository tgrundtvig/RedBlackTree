/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Kasper
 */
public interface KPMapInterface<K, V> {

    V get(K key);

    void put(K key, V data);

    int size();
}
