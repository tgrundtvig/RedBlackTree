/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.map;

import algorithms.interfaces.IRedBlackMap;
import java.util.Comparator;

/**
 *
 * @author kasper
 */
public class RedBlackMap<K, V> implements IRedBlackMap<K, V> {

    private int size = 0;
    private RedBlackNode<K, V> root;
    private Comparator<K> comp;

    public RedBlackMap(Comparator<K> comp) {
        this.root = null;
        this.comp = comp;
    }

    /**
     * Method to insert data into the map
     *
     * @param key node you wanna insert
     * @param value value of that node
     * @throws NullPointerException if key or value is null
     */
    @Override
    public void put(K key, V value) throws NullPointerException {
        if (key == null || value == null) {
            throw new NullPointerException("Something went wrong!");
        }
        this.root = put(key, value, root);
        this.root.setIsRed(false);
    }

    /**
     * Method to get the value of a node
     *
     * @param key node you are searching for
     * @return value of node
     */
    @Override
    public V get(K key) {
        RedBlackNode<K, V> node = get(key, root);

        if (node == null) {
            return null;
        }
        return node.getValue();
    }

    /**
     * Method to get size of map
     *
     * @return size of map (int).
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Helper method to put. Method will determine where to set the node (left
     * or right child)
     *
     * @param key node you want to insert
     * @param value value of node you want to insert
     * @param node parent node you are checking
     * @return node
     */
    private RedBlackNode<K, V> put(K key, V value, RedBlackNode<K, V> node) {

        if (node == null) {
            size++;
            return new RedBlackNode<>(key, value);
        }

        int compNode = comp.compare(key, node.getKey());

        if (compNode < 0) {
            node.setLeft(put(key, value, node.getLeft()));
        } else if (compNode > 0) {
            node.setRight(put(key, value, node.getRight()));
        } else {
            node.setValue(value);
        }

        //Rotate as needed if map is not leaning to the left accodingly to the 
        // left-leaning-red-black algorithm
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }

        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }

        if (isRed(node.getRight()) && isRed(node.getLeft())) {
            flipColors(node);
        }

        return node;
    }

    /**
     * Helper method to get. Method will find the node in the map.
     *
     * @param key node you are looking for
     * @param node node you are checking
     * @return the node or null if nothing is found
     */
    private RedBlackNode<K, V> get(K key, RedBlackNode<K, V> node) {
        if (node == null) {
            return null;
        }

        int compNode = comp.compare(key, node.getKey());

        if (compNode < 0) {
            return get(key, node.getLeft());
        } else if (compNode > 0) {
            return get(key, node.getRight());
        } else {
            return node;
        }
    }

    /**
     * Methods below are copied from RedBlackBST and changed to use new node for
     * map instead
     */
    private boolean isRed(RedBlackNode<K, V> node) {
        if (node == null) {
            return false;
        } else {
            return node.isRed();
        }
    }

    private RedBlackNode<K, V> rotateLeft(RedBlackNode<K, V> node) {
        RedBlackNode<K, V> tmp = node.getRight();
        node.setRight(tmp.getLeft());
        tmp.setLeft(node);
        tmp.setIsRed(node.isRed());
        node.setIsRed(true);
        return tmp;
    }

    private RedBlackNode<K, V> rotateRight(RedBlackNode<K, V> node) {
        RedBlackNode<K, V> tmp = node.getLeft();
        node.setLeft(tmp.getRight());
        tmp.setRight(node);
        tmp.setIsRed(node.isRed());
        node.setIsRed(true);
        return tmp;
    }

    private void flipColors(RedBlackNode<K, V> node) {
        node.getLeft().setIsRed(false);
        node.getRight().setIsRed(false);
        node.setIsRed(true);
    }

}
