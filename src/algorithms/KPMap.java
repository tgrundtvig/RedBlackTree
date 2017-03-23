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
public class KPMap<K, V> implements KPMapInterface<K, V>{
    
    int amount = 4;
    int size = 0;
    
    private node<K, V>[] nodes;
    
    public KPMap(){
        nodes = new node[amount];
    }
    
    public KPMap(int size){
        nodes = new node[size];
    }

    @Override
    public V get(K key) {
        int nodeIndex = key.hashCode() % nodes.length;
        node<K, V> n = nodes[nodeIndex];
        while (n != null && !key.equals(n.getKey())){
            n = n.getNext();
        }
        return n != null ? n.getValue() : null;
    }

    @Override
    public void put(K key, V data) {
        int nodeIndex = key.hashCode() % nodes.length;
        node<K, V> n = nodes[nodeIndex];
        
        if(n != null){
            boolean run = true;
            while(run){
                if(key.equals(n.getKey())){
                    n.setValue(data);
                    run = false;
                }
                else if(n.getNext() == null){
                    n.setNext(new node<>(key, data));
                    run = false;
                    size++;
                }
                n = n.getNext();
            }
        }
        else{
            nodes[nodeIndex] = new node<>(key, data);
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }
    

}
