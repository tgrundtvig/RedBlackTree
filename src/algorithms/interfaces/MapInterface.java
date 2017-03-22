/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interfaces;

/**
 *
 * @author Jonathan
 */
public interface MapInterface<Key, Value> {
    Value get(Key key);
    void put(Key key, Value value);
    int size();
}
