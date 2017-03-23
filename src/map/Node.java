/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author jonassimonsen
 */
public class Node<K, V>{
    private K key;
    private V value;
    private Node<K, V> left;
    private Node<K, V> right;
    private boolean isRed;
    
    public Node(K key, V value) {
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

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }  
}
