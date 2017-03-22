/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import algorithms.interfaces.MapInterface;
import java.util.Comparator;

/**
 *
 * @author Jonathan
 */
public class NewMap<Key, Value> implements MapInterface<Key, Value>{
    
    private MapRedBlackBST<Key, Value> rBTree;
    
    public NewMap(){
      rBTree = new MapRedBlackBST(Comparator.naturalOrder());

    }
    @Override
    public Value get(Key key) {
       return rBTree.getNode(rBTree.getRoot(), key);
    }

    @Override
    public void put(Key key, Value value) {
        rBTree.insert(key, value);
    }

    @Override
    public int size() {
       return rBTree.getSize();
    }
    
}
