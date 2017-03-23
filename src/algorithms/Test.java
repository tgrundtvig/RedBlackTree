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
        RedBlackBST<String, String> myTree = new RedBlackBST(Comparator.naturalOrder());
        myTree.put("Q", "Bison");
        myTree.put("A", "Beaver");
        myTree.put("Z", "Caterpillar");
        myTree.put("E", "Cormorant");
        myTree.put("D", "Squirrel");
        myTree.put("C", "Rhinoceros");

        System.out.println(myTree.get("C"));
        System.out.println(myTree.size());

    }
}
