package algorithms;

import Interfaces.RedBlackTreeMap;

import java.util.Comparator;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Tobias
 */
public class RedBlackBST<K, V> implements RedBlackTreeMap<K, V> {
    private RedBlackNode<K, V> root;
    private Comparator<K> comp;

    public RedBlackBST(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    // Moved to implemented Put method.
//    public void insert(E data)
//    {
//        if(data == null) throw new NullPointerException("data should not be null");
//        this.root = insert(data, root);
//        this.root.setIsRed(false);
//    }

    private RedBlackNode<K, V> insert(K key, V value, RedBlackNode<K, V> h) {
        if (h == null) return new RedBlackNode<>(key, value);
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
        if (node == null) return false;
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
    public void put(K key, V value) {
        if (key == null) throw new NullPointerException("data should not be null");
        this.root = insert(key, value, root);
        this.root.setIsRed(false);
    }

    @Override
    public V get(K key) {
        if (key == null) throw new NullPointerException("data should not be null");
        return find(key);
    }

    private V find(K key) {
        RedBlackNode x = root;
        while(x != null){
            //da fuk? why the casting hell
            int cmp = comp.compare(key, (K) x.getKey());
            if(cmp < 0) x = x.getLeft();
            else if(cmp > 0) x = x.getRight();
            else return (V) x.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        if(root==null) return 0;
        return getSize(root);
    }

    private int getSize(RedBlackNode<K, V> node){
        if(node == null) return 0;
        return 1 + getSize(node.getLeft()) + getSize(node.getRight());
    }
}
