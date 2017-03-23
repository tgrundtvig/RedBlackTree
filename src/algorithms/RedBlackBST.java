package algorithms;

import Interfaces.Map;
import java.util.Comparator;

/*
 * Added the MOS implementation to the balanced searchtree
 * The MOS(Middleout search) created by Dennis Andersen implements
 * a hashcode valuation to check if the Node's key corresponds to a
 * even- or an uneven hashcode value. This is used to create a second
 * root of the BST to hold either even or uneven elements. Which will
 * half the tree size in best case and thereby improve the tree.
 */

/**
 *
 * @author Dennis Andersen
 */
public class RedBlackBST<k, v> implements Map<k,v>
{
    private RedBlackNode<k, v> evenRoot, unevenRoot;
    private Comparator<k> comp;
    private int evenSize, unevenSize;

    public RedBlackBST(Comparator<k> comp)
    {
        this.evenRoot = null;
        this.unevenRoot = null;
        this.comp = comp;
        this.evenSize = 0;
        this.unevenSize = 0;
    }
    
    @Override
    public void insert(k key, v value)
    {
        if(key == null) throw new NullPointerException("key should not be null");
        if(key.hashCode() % 2 == 0){
            this.evenRoot = insert(key, value, evenRoot, true);
            this.evenRoot.setIsRed(false);
        } else {
            this.unevenRoot = insert(key, value, unevenRoot, false);
            this.unevenRoot.setIsRed(false);
        }
    }
    
    private RedBlackNode<k, v> insert(k key, v value, RedBlackNode<k, v> h, boolean isEven)
    {
        if(h == null) {
            if(isEven)  { evenSize++; }
            else        { unevenSize++; }
            return new RedBlackNode<>(key, value);
        }
        int c = comp.compare(key, h.getKey());
        
        if      (c < 0)         { h.setLeft(insert(key, value, h.getLeft(), isEven)); }
        else if (c > 0)         { h.setRight(insert(key, value, h.getRight(), isEven)); }
        else                    { h.setValue(value); }
        
        //Now for the rotating
        if(isRed(h.getRight())  && !isRed(h.getLeft()))             { h = rotateLeft(h); }
        if(isRed(h.getLeft())   && isRed(h.getLeft().getLeft()))    { h = rotateRight(h); }
        if(isRed(h.getLeft())   && isRed(h.getRight()))             { flipColors(h); }
        
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
    public v get(k key) {
        if(key.hashCode() % 2 == 0){ 
            return find(key, evenRoot); 
        }
        return find(key, unevenRoot);
    }
    
    private v find(k key, RedBlackNode<k,v> root) {
        if(root == null) { return null; }
        
        int c = comp.compare(key, root.getKey());
        
        if(c == 0)  { return root.getValue();}
        if(c < 0)   { return find(key, root.getLeft());}
        return find(key, root.getRight());
    }

    @Override
    public int size() {
        return this.evenSize + this.unevenSize;
    }
    
    @Override
    public int evenSize() {
        return this.evenSize;
    }
    
    @Override
    public int unevenSize() {
        return this.unevenSize;
    }
}
