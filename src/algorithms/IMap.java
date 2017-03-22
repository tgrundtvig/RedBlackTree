/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import com.sun.media.sound.InvalidDataException;

/**
 *
 * @author Alexander
 */
public interface IMap<K, V> {
    
    void put(K key, V val) throws NullPointerException;
    
    V get(K key);
    
    int size();
    
}
