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
        RedBlackBST<Integer, String> myTree = new RedBlackBST<Integer, String>(Comparator.naturalOrder());
        myTree.put(5, "Value5");
        myTree.put(1, "Value1");
        myTree.put(3, "Value3");
        myTree.put(4, "Value4");
        myTree.put(2, "Value2");
        System.out.println("Value for key 2:" + myTree.getValue(2));
        System.out.println("Size found with recursion: " + myTree.sizeRecursive());
/*        myTree.insert("Q");
        myTree.insert("A");
        myTree.insert("Z");
        myTree.insert("E");
        myTree.insert("D");
        myTree.insert("C");*/
       
    }
}
