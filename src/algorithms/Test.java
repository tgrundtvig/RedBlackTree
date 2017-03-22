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
        RedBlackBST<String, Integer> myTree = new RedBlackBST<String, Integer>(Comparator.naturalOrder());
        myTree.put("Q", 2);
        myTree.put("A", 4);
        myTree.put("Z", 8);
        myTree.put("E", 6);
        myTree.put("D", 1);
        myTree.put("C", 3);
        System.out.println(myTree.size());
        System.out.println(myTree.get("Z"));
        System.out.println(myTree.get("C"));
    }
}
