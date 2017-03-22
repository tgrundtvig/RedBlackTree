/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import com.sun.media.sound.InvalidDataException;
import java.util.Comparator;

/**
 *
 * @author Alexander
 */
public class RedBlackMap<K, V> implements IMap<K, V> {

    int size = 0;
    private RedBlackMapNode<K, V> root;
    private Comparator<K> comp;

    public RedBlackMap(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    @Override
    public void put(K key, V val) throws NullPointerException {
        if (key == null || val == null) {
            throw new NullPointerException("Stupid you!");
        }
        this.root = put(key, val, root);
        this.root.setIsRed(false);
    }

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return size;
    }

    private RedBlackMapNode<K, V> put(K key, V val, RedBlackMapNode<K, V> node) {
        if (node == null) {
            size++;
            return new RedBlackMapNode<>(key, val);
        }

        int c = comp.compare(key, node.getKey());
        if (c < 0) {
            node.setLeft(put(key, val, node.getLeft()));
        } else if (c > 0) {
            node.setRight(put(key, val, node.getRight()));
        } else {
            node.setVal(val);
        }
        
        //Now for the rotating
        if(isRed(node.getRight()) && !isRed(node.getLeft()))
        {
            node = rotateLeft(node);
        }
        
        if(isRed(node.getLeft()) && isRed(node.getLeft().getLeft()))
        {
            node = rotateRight(node);
        }
        
        if(isRed(node.getLeft()) && isRed(node.getRight()))
        {
            flipColors(node);
        }
        return node;
        
    }
    
     private boolean isRed(RedBlackMapNode<K, V> node)
    {
        if(node == null) return false;
        return node.isRed();
    }
    
    private RedBlackMapNode<K, V> rotateLeft(RedBlackMapNode<K, V> h)
    {
        RedBlackMapNode<K, V> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private RedBlackMapNode<K, V> rotateRight(RedBlackMapNode<K, V> h)
    {
        RedBlackMapNode<K, V> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private void flipColors(RedBlackMapNode<K, V> h)
    {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }

}
