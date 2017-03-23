package algorithms;

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
    
    public void insert(E data)// is a comparator DATA (value in the NODE)
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
    
    public RedBlackNode<E> get(E data){// data is value from the node, the key
        if (data == null) {
            throw new NullPointerException();//nothing to get
        }
        return get(root, data);
    }
    
    private RedBlackNode<E> get(RedBlackNode<E> node, E data){
    
        while(node != null){
        int temp = comp.compare(data, node.getData());
            if (temp < 0) {
                node = node.getLeft();
            }else if (temp > 0) {
                node = node.getRight();
            }else{
                return node;
            }
        } 
        return null;
    }
}
