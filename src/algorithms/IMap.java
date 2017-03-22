/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Alexander
 */
public interface IMap<K, V> {
    
    void put(K key, V val);
    
    V get(K key);
    
    int size();
    
}
