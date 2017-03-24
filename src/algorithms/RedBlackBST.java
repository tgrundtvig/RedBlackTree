package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import static javax.management.Query.value;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tobias
 */
public class RedBlackBST<k, v> implements Map<k, v>
{   
    private int size;
    private int length = 1;
    private RedBlackNode<k, v>[] nodeList = new RedBlackNode[length];
    private RedBlackNode<k,v> root;
    private Comparator<k> comp;

    public RedBlackBST(Comparator<k> comp)
    {
        this.root = null;
        this.comp = comp;
    }
    @Override
    public void put(k key, v value) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (nodeList[i].getData().equals(key)) {
                nodeList[i].setValue(value);
                insert = false;
            }
        }
        if (insert) {
            if (size == nodeList.length) {
                int newSize = nodeList.length * 2;
                nodeList = Arrays.copyOf(nodeList, newSize);
            }
            nodeList[size++] = new RedBlackNode<k, v>(key, value);
        }
    }
    @Override
    public v get(k key) {
        for(int i = 0; i < size; i++) {
            if (nodeList[i] != null) {
                if (nodeList[i].getData().equals(key)) {
                     return nodeList[i].getValue();    
                }
            }
        }
        return null;
    }
    
    private RedBlackNode<k, v> insert(k data, RedBlackNode<k, v> h)
    {
        if(h == null) return new RedBlackNode<>(data, h.getValue());
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
        
    private boolean isRed(RedBlackNode<k, v> node)
    {
        if(node == null) return false;
        return node.isRed();
    }
    
    private RedBlackNode<k, v> rotateLeft(RedBlackNode<k, v> h)
    {
        RedBlackNode<k, v> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private RedBlackNode<k, v> rotateRight(RedBlackNode<k, v> h)
    {
        RedBlackNode<k, v> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private void flipColors(RedBlackNode<k, v> h)
    {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }
    
    @Override
    public int size() {
    return size;
    }
}
