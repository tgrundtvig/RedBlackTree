/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import algorithms.map.RedBlackMap;
import algorithms.tree.RedBlackBST;
import java.util.Comparator;

/**
 *
 * @author Tobias
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("TreeTest");
        testTree();
        System.out.println("\nMapTest");
        testMap();
    }

    private static void testTree() {
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

    private static void testMap() {
        RedBlackMap<String, String> myMap = new RedBlackMap<String, String>(Comparator.naturalOrder());
        System.out.println("Size = " + myMap.size());
        myMap.put("Q", "QQ");
        myMap.put("A", "AA");
        myMap.put("Z", "ZZ");
        myMap.put("E", "EE");
        myMap.put("D", "DD");
        myMap.put("C", "CC");
        myMap.put("T", "TT");
        myMap.put("G", "GG");
        myMap.put("B", "BB");
        System.out.println("Size = " + myMap.size());

        //Searching - testing get method
        //Will print null since its not in the tree
        System.out.println("Search for W - " + "Value is: " + myMap.get("W"));
        //Will print Q since it is in the tree
        System.out.println("Search for Q - " + "Value is: " + myMap.get("Q"));
    }

}
