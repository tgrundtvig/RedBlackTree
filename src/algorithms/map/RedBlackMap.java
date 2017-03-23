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

    @Override
    public void put(K key, V value) throws NullPointerException {
        if (key == null || value == null) {
            throw new NullPointerException("Something went wrong!");
        }
        this.root = put(key, value, root);
        this.root.setIsRed(false);
    }

    @Override
    public V get(K key, V value) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

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

    private void get() {

    }

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
