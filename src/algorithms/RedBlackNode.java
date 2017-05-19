package algorithms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohammed Salameh
 */
public class RedBlackNode<K,V> {
    
    private K data;
    private V value;
    
    private RedBlackNode<K,V> left, right;
    private boolean isRed;
    
    public K getData() {
        return data;
    }
    
    public RedBlackNode<K, V> getLeft() {
        return left;
    }
    
    public RedBlackNode<K, V> getRight() {
        return right;
    }
    
    public boolean isRed() {
        return isRed;
    }
    
    public void setLeft(RedBlackNode left) {
        this.left = left;
    }
    
    public void setRight(RedBlackNode right) {
        this.right = right;
    }
    
    public void setRed(boolean red) {
        isRed = red;
    }
    
    public void setData(K data) {
        this.data = data;
    }
    
    public RedBlackNode(K data, V value) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }
    
}
