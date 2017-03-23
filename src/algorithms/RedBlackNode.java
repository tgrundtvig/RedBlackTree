package algorithms;

/**
 *
 * @author Tobias
 */
public class RedBlackNode<k,v>
{
    private v value;
    private k data;
    private RedBlackNode<k,v> left;
    private RedBlackNode<k,v> right;
    private boolean isRed;

    public RedBlackNode(k data,v value)
    {
        this.value = value;
        this.data = data;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    public v getValue() {
        return value;
    }

    public void setValue(v value) {
        this.value = value;
    }

    
    
    
    
    public k getData()
    {
        return data;
    }

    public void setData(k data)
    {
        this.data = data;
    }

    public RedBlackNode<k,v> getLeft()
    {
        return left;
    }

    public void setLeft(RedBlackNode left)
    {
        this.left = left;
    }

    public RedBlackNode<k,v> getRight()
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
