package algorithms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tobias
 */
public class RedBlackBST<K,V> implements MapInterface<K,V>
{
    private RedBlackNode<K, V> root;
    private Comparator<K> comp;
    private int size;
    public RedBlackBST(Comparator<K> comp)
    {
        this.root = null;
        this.comp = comp;
        this.size = 0;
    }
    
    public void insert(K key, V value)
    {
        if(key == null || value == null) throw new NullPointerException("data should not be null");
        this.root = insert(key, value, root);
        this.root.setIsRed(false);
    }
    
    private RedBlackNode<K,V> insert(K key, V value, RedBlackNode<K,V> h)
    {
        if(h == null) {
            size++;
            return new RedBlackNode<>(key,value);
        }
        int c = comp.compare(key, h.getKey());
        if(c < 0)
        {
            h.setLeft(insert(key,value, h.getLeft()));
        }
        else if(c > 0)
        {
            h.setRight(insert(key,value, h.getRight()));
        }
        else
        {
            h.setKey(key);
        }
        //Now for the rotating
        if(isRed(h.getRight()) && !isRed(h.getLeft()))
        {
            h = rotateLeft(h);
        }
        
        if(isRed(h.getLeft()) && isRed(h.getLeft().getLeft()))
        {
            h = rotateRight(h);
        }
        
        if(isRed(h.getLeft()) && isRed(h.getRight()))
        {
            flipColors(h);
        }
        return h;
    }
    
    private boolean isRed(RedBlackNode<K,V> node)
    {
        if(node == null) return false;
        return node.isRed();
    }
    
    private RedBlackNode<K,V> rotateLeft(RedBlackNode<K,V> h)
    {
        RedBlackNode<K,V> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private RedBlackNode<K,V> rotateRight(RedBlackNode<K,V> h)
    {
        RedBlackNode<K,V> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private void flipColors(RedBlackNode<K,V> h)
    {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }   

    @Override
    public void put(K key, V value) {
        if(key == null){
            throw new NullPointerException("data should not be null");
            
        }
        this.root = insert(key, value, root); 
        this.root.setIsRed(false);
        
    }

    @Override
    public V get(K key) {
         if (key == null) throw new NullPointerException();
         RedBlackNode<K,V> tmp = get(key, root);
         if (tmp == null) {
            return null;
        }
        return tmp.getValue();
        
    }

    @Override
    public int size() {
        return size;    
    }
    
     private RedBlackNode<K, V> get(K key, RedBlackNode<K, V> node) {
       if(node == null) return null;
     
       int c = comp.compare(key, node.getKey());
       if(c > 0) {
            return get(key, node.getRight());
        } else if (c < 0) {
            return get(key, node.getLeft());
        } else {
           return node;
         }
    }
}
