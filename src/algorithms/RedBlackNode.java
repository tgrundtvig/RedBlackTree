package algorithms;

/**
 *
 * @author Tobias
 */
public class RedBlackNode<K,V>
{
    private V value;
    private K data;
    private RedBlackNode<K,V> left;
    private RedBlackNode<K,V> right;
    private boolean isRed;

    public RedBlackNode(K data, V value)
    {
        this.value = value;
        this.data = data;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    public K getData()
    {
        return data;
    }

    public void setValue(V value)
    {
        this.value = value;
    }

    public V getValue()
    {
        return value;
    }

    public void setData(K data)
    {
        this.data = data;
    }

    public RedBlackNode<K,V> getLeft()
    {
        return left;
    }

    public void setLeft(RedBlackNode left)
    {
        this.left = left;
    }

    public RedBlackNode<K,V> getRight()
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