package algorithms;

/**
 * Created by mathias on 3/22/17.
 */
public interface TreeInterface<Key, Value> {
    Value get(Key key, RedBlackNode<Key, Value> value);
    void put(Key key, Value value);
    int size();
    RedBlackNode<Key, Value> getRoot();
}
