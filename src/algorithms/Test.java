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
        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
        
        //the tree is empty and the get method should return null;
        System.out.println(myTree.get("A"));
        
        myTree.insert("Q"); 
        myTree.insert("A");
        myTree.insert("Z");
        myTree.insert("E");
        myTree.insert("D");
        myTree.insert("C");
        
        //the element A should be there
        System.out.println(myTree.get("A"));
        //the element E should be there
        System.out.println(myTree.get("E"));
        //the element H shouldnt be there, and therefor should return null
        System.out.println(myTree.get("H"));
    }
}
