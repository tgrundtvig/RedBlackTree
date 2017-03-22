/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymap;

/**
 *
 * @author Vixo
 */
public class MyNode<K, V> {
    
    private K key;
    private V value;
    private MyNode<K, V> left;
    private MyNode<K, V> right;
    private boolean isRed;

    public MyNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    
    
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MyNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(MyNode<K, V> left) {
        this.left = left;
    }

    public MyNode<K, V> getRight() {
        return right;
    }

    public void setRight(MyNode<K, V> right) {
        this.right = right;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }
    
}
