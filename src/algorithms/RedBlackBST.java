package algorithms;

import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

interface IMap<K,V>  {
    public void put(K key, V value);
    public V get(K key);
    //public void delete(K key);
}
/**
 *
 * @author MOhammed Salameh
 */
public class RedBlackBST<K,V> implements IMap<K,V> {
    
    private RedBlackNode<K, V> root;
    private Comparator<K> comp;
    private int size = 0;
    
    public RedBlackBST(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }
    
    public void put(K data, V value) {
        
        if (data == null) throw new NullPointerException("data is null");
        this.root = put(data, value, root);
        this.root.setRed(false);
        
    }
    
    @Override
    public V get(K key) {
        return null;
    }
    
    private RedBlackNode<K,V> put(K data, V value, RedBlackNode<K,V> h) {
        
        
        if (h == null) return new RedBlackNode<>(data, value);
        int c = comp.compare(data, h.getData());
        if (c < 0) {
            h.setLeft(put(data, value, h.getLeft()));
        }
        else if (c > 0) {
            h.setRight(put(data, value, h.getRight()));
        } else {
            h.setData(data);
        }
        
        //ROTATING
        //If right is red
        if (isRed(h.getRight()) && !isRed(h.getLeft())) {
            h = rotateLeft(h);
        }
        if (isRed(h.getLeft()) && isRed(h.getLeft().getLeft())) {
            h = rotateRight(h);
        }
        //both childs are red
        if (isRed(h.getLeft()) && isRed(h.getRight())) {
            flipColors(h);
        }
        
        return h;
        
    }
    
    private boolean isRed(RedBlackNode<K,V> node) {
        if (node == null) return false;
        return node.isRed();
    }
    
    private void flipColors(RedBlackNode<K,V> h) {
        
        h.getLeft().setRed(false);
        h.getRight().setRed(false);
        h.setRed(true);
        
    }
    
    private RedBlackNode<K,V> rotateLeft(RedBlackNode<K,V> h) {
        
        RedBlackNode tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setRight(h);
        tmp.setRed(h.isRed());
        h.setRed(true);
        return tmp;
        
    }
    
    private RedBlackNode<K,V> rotateRight(RedBlackNode<K,V> h) {
        
        RedBlackNode tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setRed(h.isRed());
        h.setRed(true);
        return tmp;
        
    }
    
    
}
