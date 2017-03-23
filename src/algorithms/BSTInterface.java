
package algorithms;

/**
 *
 * @author Luke
 */
public interface BSTInterface<Key, Value> {
    Value get(Key key, RedBlackNode<Key, Value> node);
    
    void put(Key key, Value value);
    
    int size();
    
    RedBlackNode<Key, Value> getRoot();
}
