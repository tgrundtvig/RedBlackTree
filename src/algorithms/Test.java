/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Comparator;

/**
 *
 * @author Tobias
 */
public class Test
{
    public static void main(String[] args)
    {
        // Map
        
        IMap<String, String> myMap = new RedBlackMap<String, String>(Comparator.naturalOrder());
        myMap.put("Q", "QQQQQQQQ");       
        myMap.put("A", "AAAAAAAA");
        myMap.put("Z", "ZZZZZZZZ");
        
        System.out.println(myMap.size());
        
        myMap.put("E", "EEEEEEEE");
        myMap.put("D", "DDDDDDDD");
        myMap.put("C", "CCCCCCCC");
        
        System.out.println(myMap.size());
        System.out.println(myMap.get("B"));        
        System.out.println(myMap.get("E"));
        
        myMap.put("E", "Hallo again");
        System.out.println(myMap.size());
        System.out.println(myMap.get("E"));

        // Tree
        
//        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
//        myTree.insert("Q"); 
//        myTree.insert("A");
//        myTree.insert("Z");
//        myTree.insert("E");
//        myTree.insert("D");
//        myTree.insert("C");  
//        
//        System.out.println(myTree.get("B"));
//        System.out.println(myTree.get("Z").getData());

    }
}
