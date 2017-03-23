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
        /*
        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
        myTree.insert("Q"); 
        myTree.insert("A");
        myTree.insert("Z");
        myTree.insert("E");
        myTree.insert("D");
        myTree.insert("C");
                */
        
        IMap<Integer, String> myTree = new RedBlackMap<Integer, String>(Comparator.naturalOrder());
        myTree.put(2, "G");
        myTree.put(10, "J");
        myTree.put(4, "A");
        myTree.put(7, "L");
        
        System.out.println(myTree.size());
        System.out.println(myTree.get(2));
        myTree.put(1, "I");
        myTree.put(20, "N");
        myTree.put(30, "S");
        
        System.out.println(myTree.get(20));
        System.out.println(myTree.size());
        
        myTree.put(13, "Y");
        
        System.out.println(myTree.size());
        System.out.println(myTree.get(20));
       
       
    }
}
