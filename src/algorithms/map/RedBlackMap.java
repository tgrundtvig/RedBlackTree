/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.map;

import algorithms.interfaces.IRedBlackMap;

/**
 *
 * @author kasper
 */
public class RedBlackMap<K, V> implements IRedBlackMap<K, V>{

    private int size = 0;
    
    @Override
    public void put(K key, V value) {
            
    }

    @Override
    public V get(K key, V value) throws NullPointerException {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
    
    private void put(){
        
        size++;
    }
    
    private void get(){
        
    }
    
}
