package algorithms;

import java.util.Comparator;

/**
 *
 * @author Tobias
 */
public class RedBlackBST<k, v> implements MapInterface<k, v> {

    private RedBlackNode<k, v> root;
    private Comparator<k> comp;
    private int size = 0;

    public RedBlackBST(Comparator<k> comp) {
        this.root = null;
        this.comp = comp;
    }

//    public void insert(k data) {
//        if (data == null) {
//            throw new NullPointerException("data should not be null");
//        }
//        this.root = insert(data, root);
//        this.root.setIsRed(false);
//    }
    private RedBlackNode<k, v> insert(k data, v value, RedBlackNode<k, v> h) {
        if (h == null) {
            return new RedBlackNode<>(data, value);
        }
        int c = comp.compare(data, h.getData());
        if (c < 0) {
            h.setLeft(insert(data, value, h.getLeft()));
        } else if (c > 0) {
            h.setRight(insert(data, value, h.getRight()));
        } else {
            h.setData(data);
        }
        //Now for the rotating
        if (isRed(h.getRight()) && !isRed(h.getLeft())) {
            h = rotateLeft(h);
        }

        if (isRed(h.getLeft()) && isRed(h.getLeft().getLeft())) {
            h = rotateRight(h);
        }

        if (isRed(h.getLeft()) && isRed(h.getRight())) {
            flipColors(h);
        }
        return h;
    }

    private boolean isRed(RedBlackNode<k, v> node) {
        if (node == null) {
            return false;
        }
        return node.isRed();
    }

    private RedBlackNode<k, v> rotateLeft(RedBlackNode<k, v> h) {
        RedBlackNode<k, v> tmp = h.getRight();
        h.setRight(tmp.getLeft());
        tmp.setLeft(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }

    private RedBlackNode<k, v> rotateRight(RedBlackNode<k, v> h) {
        RedBlackNode<k, v> tmp = h.getLeft();
        h.setLeft(tmp.getRight());
        tmp.setRight(h);
        tmp.setIsRed(h.isRed());
        h.setIsRed(true);
        return tmp;
    }

    private void flipColors(RedBlackNode<k, v> h) {
        h.getLeft().setIsRed(false);
        h.getRight().setIsRed(false);
        h.setIsRed(true);
    }

    @Override
    public void put(k key, v value) {
        this.root = insert(key, value, root);
        this.root.isRed();
    }

    public v getValue(k key, RedBlackNode<k, v> root) {
        int check = comp.compare(key, root.getData());
        if (check == 0) {
            return root.getValue();
        } else if (check > 0) {
            return getValue(key, root.getRight());
        } else {
            return getValue(key, root.getLeft());
        }
    }

    @Override
    public v get(k key) {
        return getValue(key, root);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(k key) {

        //code taken from the book 
        // Link to code : 
        // https://github.com/kevin-wayne/algs4/blob/master/src/main/java/edu/princeton/cs/algs4/BST.java
        // didn't have time to fix it to our code. :( 
//     private Node delete(Node x, Key key) {
//        if (x == null) return null;
//
//        int cmp = key.compareTo(x.key);
//        if      (cmp < 0) x.left  = delete(x.left,  key);
//        else if (cmp > 0) x.right = delete(x.right, key);
//        else { 
//            if (x.right == null) return x.left;
//            if (x.left  == null) return x.right;
//            Node t = x;
//            x = min(t.right);
//            x.right = deleteMin(t.right);
//            x.left = t.left;
//        } 
//        x.size = size(x.left) + size(x.right) + 1;
//        return x;
//    } 
    }

}
