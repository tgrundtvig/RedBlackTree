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
public class RedBlackBST<Key, Value> implements IMyMap<Key, Value>
{
    private RedBlackNode<Key, Value> root;
    private Comparator<Key> comp; //Maybe compare on value?

    public RedBlackBST(Comparator<Key> comp)
    {
        this.root = null;
        this.comp = comp;
    }

    @Override
    public Value getValue(Key key) {
        if(key == null) throw new NullPointerException("key should not be null");
        return getValue(key, this.root);
    }
    http://www.geeksforgeeks.org/red-black-tree-set-3-delete-2/
    http://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
    //Delete also works if you put in a Key and NULL value as value.
    @Override
    public void put(Key key, Value value) {
        if(key == null) throw new NullPointerException("key should not be null");
        if(value == null){} //THIS IS WHERE DELETE SHOULD BE !
        this.root = insert(key, value, root);
        this.root.setIsRed(false);
    }

    @Override
    public int size() {
        return findSizeRecursive(this.root);
    }

    //This could also be done like in the book, by setting the size of each subtree of a node, as the are inserted.
    //That would obviously be faster, but I like this recursive method.
    private int findSizeRecursive(RedBlackNode<Key, Value> h){
        if(h == null) return 0;
        else return findSizeRecursive(h.getRight()) + findSizeRecursive(h.getLeft()) + 1;
    }

    private Value getValue(Key key, RedBlackNode<Key, Value> h){
        //If H gets null, it means that we cannot find the Key in the tree.
        while(h != null){
            //Compare the current key(x) to the key we are searching for.
            //This determines left/right or if equal, we found the key. Return value
            int c = comp.compare(key, h.getKey());
            if(c < 0) h = h.getLeft();
            else if(c > 0) h = h.getRight();
            else return h.getValue();
        }
        return null;
    }

    private RedBlackNode<Key, Value> insert(Key key, Value value, RedBlackNode<Key, Value> h)
    {

        if(h == null) return new RedBlackNode<>(key, value);
        int c = comp.compare(key, h.getKey());
        if(c < 0)
        {
            h.setLeft(insert(key, value, h.getLeft()));
        }
        else if(c > 0)
        {
            h.setRight(insert(key, value, h.getRight()));
        }
        else
        {
            h.setValue(value);
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
    
    private boolean isRed(RedBlackNode<Key, Value> node)
    {
        if(node == null) return false;
        return node.isRed();
    }
    
    private RedBlackNode<Key, Value> rotateLeft(RedBlackNode<Key, Value> h)
    {
        RedBlackNode<Key, Value> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private RedBlackNode<Key, Value> rotateRight(RedBlackNode<Key, Value> h)
    {
        RedBlackNode<Key, Value> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private void flipColors(RedBlackNode<Key, Value> h)
    {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }



}
