package mymap;

import java.util.Comparator;

/**
 *
 * @author Vixo
 */
public class RedBlackMap<K, V> implements IMyMap<K, V>{

    private MyNode<K, V> root;
    private Comparator<K> comp;
    
    private int size;

    public RedBlackMap(Comparator<K> comp) {
        this.comp = comp;
        this.root = null;
        this.size = 0;
    }
    
    @Override
    public void put(K key, V value) {
        if(key == null || value == null) throw new NullPointerException("data should not be null");
        this.root = put(key, value, root);
        this.root.setIsRed(false);
    }

    @Override
    public V get(K key) {
        if(key == null) throw new NullPointerException();
        
        MyNode<K, V> tmp = get(key, root);
        if(tmp == null) return null;
        return tmp.getValue();
    }

    @Override
    public int size() {
        return size;
    }
    
    private boolean isRed(MyNode<K, V> node)
    {
        if(node == null) return false;
        return node.isRed();
    }
    
    private MyNode<K, V> rotateLeft(MyNode<K, V> h)
    {
        MyNode<K, V> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private MyNode<K, V> rotateRight(MyNode<K, V> h)
    {
        MyNode<K, V> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }
    
    private void flipColors(MyNode<K, V> h)
    {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }
    
    private MyNode<K, V> put(K key, V value, MyNode<K, V> h) {
        if(h == null) {
            size++;
            return new MyNode<K, V>(key, value);
        }
        
        int c = comp.compare(key, h.getKey());
        if(c < 0)
        {
            h.setLeft(put(key, value, h.getLeft()));
        }
        else if(c > 0)
        {
            h.setRight(put(key, value, h.getRight()));
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
    
    private MyNode<K, V> get(K key, MyNode<K, V> node) {
        if(node == null) return null;
        
        int c = comp.compare(key, node.getKey());
        if(c > 0) {
            return get(key, node.getRight());
        } else if (c < 0) {
            return get(key, node.getLeft());
        } else {
            return node;
        }
    }
}
