/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.TheMap;

/**
 *
 * @author Frederik
 */
public interface MapInterface<K,V> {
    //put returns true if the element was added, and false if it was not.
    public boolean put(K k, V v);
    public mapNode get(K k);
    public int size();
}
