/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Comparator;
import map.IMap;
import map.RedBlackMap;

/**
 *
 * @author Tobias feat. jonassimonsen
 */
public class Test
{
    public static void main(String[] args) {
        
        IMap<Integer, String> myTree = new RedBlackMap<Integer, String>(Comparator.naturalOrder());
        myTree.put(5, "Nr. 5");
        myTree.put(2, "Nr. 2");
        myTree.put(4, "Nr. 4");
        myTree.put(10, "Nr. 10");
        
        System.out.println(myTree.size());
        System.out.println(myTree.get(2));
        myTree.put(8, "Nr. 8");
        myTree.put(20, "Nr. 20");
        myTree.put(15, "Nr. 15");
        
        System.out.println(myTree.get(20));
        System.out.println(myTree.size());
        
        myTree.put(2, "Nr. 2 igen");
        
        System.out.println(myTree.size());
        System.out.println(myTree.get(2));
        
//        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
//        myTree.insert("Q"); 
//        myTree.insert("A");
//        myTree.insert("Z");
//        myTree.insert("E");
//        myTree.insert("D");
//        myTree.insert("C");
       
    }
}
