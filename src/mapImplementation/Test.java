/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapImplementation;

/**
 *
 * @author CosticaTeodor
 */
public class Test {
    
    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyMap<>();
        map.put(1, "One");
        System.out.println("Element 1 is: " + map.get(1));
        map.put(2, "Two");
        System.out.println("Element 2 is: " + map.get(2));
        map.put(3, "Three");
        System.out.println("Element 3 is: " + map.get(3));
        
        System.out.println("Size of the Map is: " +  map.size());
        
        map.remove(1);
        
        System.out.println("After removal is: " + map.size());
    }
    
}
