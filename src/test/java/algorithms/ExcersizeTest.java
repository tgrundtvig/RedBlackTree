/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Comparator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tobias
 */
public class ExcersizeTest {

    @Test
    public void mapWorks() {

        OliverMap<String> map = new OliverMap<String>();
        map.put("Test", "123");
        map.put("Hallo", "321");

        assertEquals(2, map.size());
        assertEquals("123", map.get("Test"));
        assertEquals("321", map.get("Hallo"));
        assertNull(map.get("notedsdasd"));
    }

    @Test
    public void redBlackTest() {

        RedBlackBST<String> myTree = new RedBlackBST<String>(Comparator.naturalOrder());
        myTree.insert("Q");
        myTree.insert("A");
        myTree.insert("Z");
        myTree.insert("E");
        myTree.insert("D");
        myTree.insert("C");

        assertEquals("Q", myTree.get("Q"));
        assertNull(myTree.get("notedsdasd"));
    }
}
