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
 * @author Tobias
 * @author Manish Shrestha
 */
public class Test
{
    public static void main(String[] args) {
        
        IMap<Integer, String> myTree = new RedBlackMap<Integer, String>(Comparator.naturalOrder());
        myTree.put(83, "Nr. 83");
        myTree.put(56, "Nr. 56");
        myTree.put(97, "Nr. 97");
        
        System.out.println(myTree.size());
        System.out.println(myTree.get(97));
        myTree.put(11, "Nr. 11");
        myTree.put(23, "Nr. 23");
        myTree.put(1, "Nr. 1");
        myTree.put(14, "Nr. 14");
        System.out.println(myTree.get(14));
        System.out.println(myTree.size());
        
        myTree.put(83, "Nr. 83 ++");
        
        System.out.println(myTree.size());
        System.out.println(myTree.get(83));
        
//        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
//        myTree.insert("Q"); 
//        myTree.insert("A");
//        myTree.insert("Z");
//        myTree.insert("E");
//        myTree.insert("D");
//        myTree.insert("C");
       
    }
}
