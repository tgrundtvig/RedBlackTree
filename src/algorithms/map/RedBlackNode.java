/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.map;

/**
 *
 * @author kasper
 */
public class RedBlackNode<K, V> {
    private K key;
    private V value;
    private RedBlackNode<K, V> left;
    private RedBlackNode<K, V> right;
    private boolean isRed;

    public RedBlackNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public RedBlackNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode<K, V> left) {
        this.left = left;
    }

    public RedBlackNode<K, V> getRight() {
        return right;
    }

    public void setRight(RedBlackNode<K, V> right) {
        this.right = right;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }

    
    
}
