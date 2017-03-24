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
        myTree.put("A", 100);
        myTree.put("B", 90);
        myTree.put("Z", 50);
        myTree.put("Q", 32);
        myTree.put("R", 1);
        myTree.put("C", 3);
        myTree.put("J", 39);
        myTree.put("Y", 302);
        myTree.put("P", 66);
        myTree.put("O", 85);
        System.out.println(myTree.size());
        System.out.println(myTree.get("A"));
        System.out.println(myTree.get("Z"));
        System.out.println(myTree.get("Y"));
        System.out.println(myTree.get("Z"));
    }
}
