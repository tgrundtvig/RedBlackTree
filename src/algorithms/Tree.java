package algorithms;

import java.util.Comparator;

/**
 * Created by mathias on 3/22/17.
 */
public class Tree<Key, Value> implements TreeInterface<Key, Value> {

    private RedBlackBST<Key, Value> tree;

    public Tree() {
        tree = new RedBlackBST(Comparator.naturalOrder());
    }

    @Override
    public Value get(Key key, RedBlackNode<Key, Value> value) {
        return tree.get(key, value);
    }

    @Override
    public void put(Key key, Value value) {
        tree.insert(key, value);
    }

    @Override
    public int size() {
        return tree.getSize();
    }

    @Override
    public RedBlackNode<Key, Value> getRoot() {
        return tree.getRoot();
    }


}