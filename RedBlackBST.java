package algorithms;

import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tobias
 */
public class RedBlackBST<K, V> implements IntefaceMap<K, V> {

    private RedBlackNode<K, V> root;
    private Comparator<K> comp;

    public RedBlackBST(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("data should not be null");
        }
        this.root = insert(key, value, root);
        this.root.setIsRed(false);
    }

    private RedBlackNode<K, V> insert(K key, V value, RedBlackNode<K, V> h) {
        if (h == null) {
            return new RedBlackNode<>(key, value);
        }
        int c = comp.compare(key, h.getKey());
        if (c < 0) {
            h.setLeft(insert(key, value, h.getLeft()));
        } else if (c > 0) {
            h.setRight(insert(key, value, h.getRight()));
        } else {
            h.setKey(key);
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
    public V get(K key) {
        RedBlackNode r = root;
        while (r != null) {
            int result = comp.compare(key, (K) r.getKey());
            if (result == 0) {
                return (V) r.getValue();
            } else if (result > 0) {
                r = r.getRight();
            } else {
                r = r.getLeft();
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (root.equals(null)) {
            return 0;
        } else {
            return size(root);
        }

    }

    private int size(RedBlackNode<K, V> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }
}
