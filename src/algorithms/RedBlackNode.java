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
public class RedBlackNode<k, v>
{
    private k key;
    private v value;
    private RedBlackNode<k, v> left;
    private RedBlackNode<k, v> right;
    private boolean isRed;

    public RedBlackNode(k key, v value)
    {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    public k getKey()
    {
        return this.key;
    }

    public void setKey(k key)
    {
        this.key = key;
    }
    
    public v getValue() {
        return this.value;
    }
    
    public void setValue(v value) {
        this.value = value;
    }

    public RedBlackNode<k, v> getLeft()
    {
        return left;
    }

    public void setLeft(RedBlackNode left)
    {
        this.left = left;
    }

    public RedBlackNode<k, v> getRight()
    {
        return right;
    }

    public void setRight(RedBlackNode right)
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
