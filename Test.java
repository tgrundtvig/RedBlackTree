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
        RedBlackBST<String, String> myTree = new RedBlackBST<String, String>(Comparator.naturalOrder());
        myTree.put("Q", "Quiz"); 
        myTree.put("A", "Alphabet");
        myTree.put("Z", "Zebra");
        myTree.put("E", "Emil");
        myTree.put("D", "Duck");
        myTree.put("C", "Citrus");
        
        System.out.println(myTree.size());
        System.out.println(myTree.get("Z"));
        
    }
}
