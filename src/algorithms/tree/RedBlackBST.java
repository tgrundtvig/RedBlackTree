package algorithms.tree;

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
public class RedBlackBST<E>
{
    private RedBlackNode<E> root;
    private Comparator<E> comp;

    public RedBlackBST(Comparator<E> comp)
    {
        this.root = null;
        this.comp = comp;
    }
    
    /**
     * Public method to search the tree
     * 
     * @param data data you are searching for
     * @return returns data if found
     */
    public RedBlackNode<E> get(E data){
        return get(data, root);
    }
    
    /**
     * Private method to search the tree.
     * Checking if value is greater than root, and decides to go left or right
     * runs recursively till it finds a match
     * 
     * @param data data you search for
     * @param node node you compare data with
     * @return returns the node if found, or throws null pointer
     */
    private RedBlackNode<E> get(E data, RedBlackNode<E> node){
        if(node == null){
            return null;
        }
        
        int compNode = comp.compare(data, node.getData());
        if(compNode < 0){
            return get(data, node.getLeft());
        } else if(compNode > 0){
            return get(data, node.getRight());
        } else {
            return node;
        }        
    }
    
    public void insert(E data)
    {
        if(data == null) throw new NullPointerException("data should not be null");
        this.root = insert(data, root);
        this.root.setIsRed(false);
    }
    
    private RedBlackNode<E> insert(E data, RedBlackNode<E> h)
    {
        if(h == null) return new RedBlackNode<>(data);
        int c = comp.compare(data, h.getData());
        if(c < 0)
        {
            h.setLeft(insert(data, h.getLeft()));
        }
        else if(c > 0)
        {
            h.setRight(insert(data, h.getRight()));
        }
        else
        {
            h.setData(data);
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
    
    private boolean isRed(RedBlackNode<E> node)
    {
        if(node == null) return false;
        return node.isRed();
    }
    
    private RedBlackNode<E> rotateLeft(RedBlackNode<E> h)
    {
        RedBlackNode<E> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private RedBlackNode<E> rotateRight(RedBlackNode<E> h)
    {
        RedBlackNode<E> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private void flipColors(RedBlackNode<E> h)
    {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }
}
