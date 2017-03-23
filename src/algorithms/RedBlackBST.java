package algorithms;

import java.util.Comparator;

public class RedBlackBST<K, V> implements BSTInterface<K, V> {
    private RedBlackNode<K, V> root;
    private Comparator<K> comp;
    private int size = 0;
    
    public RedBlackBST(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    public void insert(K data, V value) {
        if (data == null) {
            throw new NullPointerException("data should not be null");
        }
        
        this.root = insert(data, value, root);
        this.root.setIsRed(false);
    }

    private RedBlackNode<K, V> insert(K data, V value, RedBlackNode<K, V> h) {
        if (h == null) {
            size++;
            return new RedBlackNode<>(data, value);
        }

        int c = comp.compare(data, h.getData());
        
        if (c < 0) {
            h.setLeft(insert(data, value, h.getLeft()));
        } else if (c > 0) {
            h.setRight(insert(data, value, h.getRight()));
        } else {
            h.setData(data);
            h.setValue(value);
            size++;
        }
        
        //Now for the rotating
        if (isRed(h.getRight()) && !isRed(h.getLeft())) {
            h = rotateLeft(h);
        }

        if (isRed(h.getLeft()) && isRed(h.getLeft().getLeft())) {
            h = rotateRight(h);
        }

        if (isRed(h.getLeft()) && isRed(h.getRight())) {
            flipColors(h);
        }
        
        return h;
    }

    private boolean isRed(RedBlackNode<K, V> node) {
        if (node == null) {
            return false;
        }
        
        return node.isRed();
    }

    private RedBlackNode<K, V> rotateLeft(RedBlackNode<K, V> h) {
        RedBlackNode<K, V> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        
        return tmp;
    }

    private RedBlackNode<K, V> rotateRight(RedBlackNode<K, V> h) {
        RedBlackNode<K, V> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        
        return tmp;
    }

    private void flipColors(RedBlackNode<K, V> h) {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }

    @Override
    public V get(K key, RedBlackNode<K, V> node) {
        int c = comp.compare(key, node.getData());

        if (c < 0) {
            // to the left
            return get(key, node.getLeft());
        }else if (c > 0) {
            // to the right
            return get(key, node.getRight());
        }else {
            // finally returning the value!
            return node.getValue();
        }
    }

    @Override
    public void put(K key, V value) {
        this.insert(key, value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public RedBlackNode getRoot() {
        return root;
    }
}
