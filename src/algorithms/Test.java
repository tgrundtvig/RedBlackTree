/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Comparator;
import mymap.IMyMap;
import mymap.RedBlackMap;

/**
 *
 * @author Tobias
 */
public class Test
{
    public static void main(String[] args)
    {
        IMyMap<Integer, String> myTree = new RedBlackMap<Integer, String>(Comparator.naturalOrder());
        myTree.put(5, "hej5");
        myTree.put(2, "hej2");
        myTree.put(4, "hej4");
        myTree.put(10, "hej10");
        
        System.out.println(myTree.size());
        System.out.println(myTree.get(2));
        myTree.put(8, "hej8");
        myTree.put(20, "hej20");
        myTree.put(15, "hej15");
        
        System.out.println(myTree.get(20));
        System.out.println(myTree.size());
        
        myTree.put(2, "hej igen2");
        
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
