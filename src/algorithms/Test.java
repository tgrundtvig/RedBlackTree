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
      MapInterface<Integer, String> tree = new RedBlackBST<Integer, String>(Comparator.naturalOrder());
      tree.put(7, "7");
      tree.put(2, "2");
      tree.put(5, "5");
      tree.put(10, "10");
        
       System.out.println(tree.size());
       System.out.println(tree.get(2));
       
       
    }
}
