package algorithms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tobias
 */
public class MapRedBlackNode<K, V>
{
    private K key;
    private V value;
    
    private MapRedBlackNode<K,V> left;
    private MapRedBlackNode<K,V> right;
    private boolean isRed;

    public MapRedBlackNode(K key, V value)
    {
        this.value = value;
        this.key = key;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    public K getData()
    {
        return key;
    }

    public void setKey(K data)
    {
        this.key = data;
    }
    public void setValue(V value){
        this.value =value;
    }
    public MapRedBlackNode<K,V> getLeft()
    {
        return left;
    }

    public void setLeft(MapRedBlackNode left)
    {
        this.left = left;
    }

    public V getValue() {
        return value;
    }

    public MapRedBlackNode<K,V> getRight()
    {
        return right;
    }

    public void setRight(MapRedBlackNode right)
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
