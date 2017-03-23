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
public class RedBlackBST<K, V> implements IRedBlackMap<K, V> {

    private RedBlackNode<K, V> root;
    private Comparator<K> comp;

    public RedBlackBST(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    @Override
    public void put(K key, V data) {
        if (data == null) {
            throw new NullPointerException("data should not be null");
        }
        this.root = insert(key, data, root);
        this.root.setIsRed(false);
    }

    private RedBlackNode<K, V> insert(K key, V data, RedBlackNode<K, V> h) {
        if (h == null) {
            return new RedBlackNode<>(key, data);
        }
        int c = comp.compare(key, h.getKey());
        if (c < 0) {
            h.setLeft(insert(key, data, h.getLeft()));
        } else if (c > 0) {
            h.setRight(insert(key, data, h.getRight()));
        } else {
            h.setData(data);
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
    
    /*
    public RedBlackNode<E> get(E data) {
        RedBlackNode<E> tempNode = root;

        while (tempNode != null) {
            int r = comp.compare(data, tempNode.getData());

            if (r < 0) {
                // Less
                tempNode = tempNode.getLeft();
            } else if (r > 0) {
                // Greater
                tempNode = tempNode.getRight();
            } else {
                // Equal
                return tempNode;
            }
        }
        return null;
    }   
     */    

    @Override
    public V get(K key) {
        RedBlackNode<K, V> tempNode = root;

        while (tempNode != null) {
            int r = comp.compare(key, tempNode.getKey());

            if (r < 0) {
                // Less
                tempNode = tempNode.getLeft();
            } else if (r > 0) {
                // Greater
                tempNode = tempNode.getRight();
            } else {
                // Equal
                return tempNode.getData();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }
    
    private int size(RedBlackNode<K,V> node){
        if (node == null){ 
            return 0; 
        }
        else {
            int leftInt = size(node.getLeft());
            int rightInt = size(node.getRight());
            return 1 + leftInt + rightInt;
        }
    }
}
