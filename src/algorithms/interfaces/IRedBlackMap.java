/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interfaces;

/**
 *
 * @author kasper
 */
public interface IRedBlackMap<K, V> {
    public void put(K key, V value) throws NullPointerException;
    public V get(K key);
    public int size();
}
