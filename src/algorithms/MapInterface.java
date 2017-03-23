/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author abj
 */
public interface MapInterface<Key,Value> {
    
    void put(Key key, Value value);
    Value get(Key key);
    int size();
    
}
