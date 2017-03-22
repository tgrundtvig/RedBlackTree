/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import algorithms.interfaces.MapInterface;
import java.util.Comparator;

/**
 *
 * @author Tobias
 */
public class Test {

    public static void main(String[] args) {
        /*
        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
        myTree.insert("Q"); 
        myTree.insert("A");
        myTree.insert("Z");
        myTree.insert("E");
        myTree.insert("D");
        myTree.insert("C");
        System.out.println("Result: "+myTree.getNode("Z"));
       
        System.out.println("Result rec+"+myTree.getNodeRec( myTree.getRoot(),"D"));
         */
        MapInterface<Integer, String> myMap = new NewMap<>();
        myMap.put(3, "Liverpool");
        myMap.put(1, "Arsenal");
        myMap.put(2, "Everton");
        myMap.put(5, "Chelsea");
        myMap.put(4, "Manchester city");
        
        System.out.println("shitty shiity  :"+myMap.get(4));
        System.out.println("come on "+myMap.get(1));
    }
}
