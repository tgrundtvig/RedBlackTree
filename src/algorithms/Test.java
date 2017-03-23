/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import algorithms.tree.RedBlackBST;
import java.util.Comparator;

/**
 *
 * @author Tobias
 */
public class Test
{
    public static void main(String[] args)
    {
        //Simple test of the tree
        //Adding data
        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
        myTree.insert("Q"); 
        myTree.insert("A");
        myTree.insert("Z");
        myTree.insert("E");
        myTree.insert("D");
        myTree.insert("C");
        myTree.insert("T");
        myTree.insert("G");
        myTree.insert("B");
       
        //Searching - testing get method
        //Will print null since its not in the tree
        System.out.println("Search for W - " + "Data is: " + myTree.get("W"));
        //Will print Q since it is in the tree
        System.out.println("Search for Q - " + "Data is: " + myTree.get("Q").getData());
    }
}
