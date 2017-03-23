/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import Interfaces.Map;
import java.util.Comparator;

/**
 *
 * @author Tobias
 */
public class Test
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> myTree = new RedBlackBST<Integer, Integer>(Comparator.naturalOrder());
        myTree.insert(2, 2); 
        myTree.insert(5, 5);
        myTree.insert(3, 3);
        myTree.insert(8, 8);
        myTree.insert(6, 6);
        myTree.insert(0, 0);
        myTree.insert(1, 1);
        myTree.insert(13, 13);
        myTree.insert(25, 25);
        myTree.insert(66, 66);
        myTree.insert(83, 83);
        myTree.insert(22, 22);
        myTree.insert(19, 19);
        myTree.insert(43, 43);
        myTree.insert(96, 96);
        myTree.insert(100, 100);
        
        System.out.println("Value of: 43 is: " + myTree.get(43));
       
        
        System.out.println(myTree.evenSize());
        System.out.println(myTree.unevenSize());
    }
}
