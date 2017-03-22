/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Alexander
 */
public class RedBlackMapNode<K, V> {
    
    private K key;
    private V val;
    private RedBlackMapNode<K, V> left;
    private RedBlackMapNode<K, V> right;
    private boolean isRed;

    public RedBlackMapNode(K key, V val)
    {
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    public V getVal()
    {
        return val;
    }

    public void setVal(V val)
    {
        this.val = val;
    }

    public RedBlackMapNode<K, V> getLeft()
    {
        return left;
    }

    public void setLeft(RedBlackMapNode left)
    {
        this.left = left;
    }

    public RedBlackMapNode<K, V> getRight()
    {
        return right;
    }

    public void setRight(RedBlackMapNode right)
    {
        this.right = right;
    }

    public boolean isRed()
    {
        return isRed;
    }

    public void setIsRed(boolean isRed)
    {
        this.isRed = isRed;
    }
    
    
}
