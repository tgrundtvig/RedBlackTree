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
public class MapRedBlackBST<K,V> {

    private MapRedBlackNode<K,V> root;
    private Comparator<K> comp;
    private int size;
    public MapRedBlackBST(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
        size = 0;
    }

    public void insert(K key, V value) {
        if (key == null) {
            throw new NullPointerException("data should not be null");
        }
        this.root = insert(key,value, root);
        this.root.setIsRed(false);
    }
    public MapRedBlackNode<K,V> getRoot(){
        return root;
    }
    public int getSize(){
        return size;
    }

    private MapRedBlackNode<K,V> insert(K key,V value ,MapRedBlackNode<K,V> h) {
        if (h == null) {
            size++;
            return new MapRedBlackNode<>(key,value);
        }
        int c = comp.compare(key, h.getData());
        if (c < 0) {
            h.setLeft(insert(key, value, h.getLeft()));
        } else if (c > 0) {
            h.setRight(insert(key, value, h.getRight()));
        } else {
            h.setKey(key);
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

    private boolean isRed(MapRedBlackNode<K,V> node) {
        if (node == null) {
            return false;
        }
        return node.isRed();
    }

    private MapRedBlackNode<K,V> rotateLeft(MapRedBlackNode<K,V> h) {
        MapRedBlackNode<K,V> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }

    private MapRedBlackNode<K,V> rotateRight(MapRedBlackNode<K,V> h) {
        MapRedBlackNode<K,V> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }

    private void flipColors(MapRedBlackNode<K,V> h) {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }

    int compareNodes;

    public V getNode(MapRedBlackNode<K,V> pointer, K findThis) {
        if (pointer == null) {
            throw new NullPointerException("No String found");
        }
        
        compareNodes = comp.compare(pointer.getData(), findThis);
        System.out.println("compareNodes: " + compareNodes);
        if (compareNodes > 0) {
            //Search in left side
            return getNode(pointer.getLeft(), findThis);
        } else if (compareNodes < 0) {
            // Search in right side
            return getNode(pointer.getRight(), findThis);
        } else {
            return pointer.getValue();
        }
    }

}
