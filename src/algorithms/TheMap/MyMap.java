/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.TheMap;

import java.util.ArrayList;

/**
 *
 * @author Frederik
 */
public class MyMap<K,V> implements MapInterface<K, V>{
    private ArrayList<mapNode> elements = new ArrayList(); 

    @Override
    public boolean put(K k, V v) {
        boolean existCheck = true;
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getKey().equals(k)){
                existCheck = false;
            }
        }
        if(existCheck){
            elements.add(new mapNode(k, v));
        }
        return existCheck;
    }

    @Override
    public mapNode get(K k) {
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getKey().equals(k)){
                return elements.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elements.size();
    }
    
    public static void main(String[] args) {
        MyMap<String,Integer> test = new MyMap<>();
        
        System.out.println("the size is currently: " + test.size());
        System.out.println("Adding 1st element went: " + test.put("a", 1));
        System.out.println("Adding 2nd element went: " + test.put("b", 2));
        System.out.println("Adding 3th element went: " + test.put("c", 3));
        System.out.println("the size is currently: " + test.size());
        System.out.println("Adding 4th element went: " + test.put("a", 4));
        System.out.println("the size is currently: " + test.size());
        System.out.println("Element to key \"a\" should be 1, and is: " + test.get("a").getValue());
        System.out.println("Element to key \"b\" should be 2, and is: " + test.get("b").getValue());
        System.out.println("Element to key \"c\" should be 3, and is: " + test.get("c").getValue());
    }
   
}
