/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Kasper
 */
public class node<K, V> {
    private node<K, V> next;
    private K key;
    private V value;
    
    public node(K key, V value){
        this.key = key;
        this.value = value;
    }
    
    public K getKey(){
        return key;
    }
    
    public V getValue(){
        return value;
    }
    
    public void setValue(V value){
        this.value = value;
    }
    
    public void setNext(node<K, V> next){
        this.next = next;
    }
    
    public node<K, V> getNext(){
        return next;
    }
    
}
