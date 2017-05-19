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
        //Inputs
        //Q A Z E D C T G B
    
        RedBlackBST<String,String> tree = new RedBlackBST<String,String>(Comparator.naturalOrder());
        tree.put("Q","Que");
        tree.put("A","A");
        tree.put("Z","Z");
        tree.put("E","E");
        tree.put("D","D");
        tree.put("C","C");
       
    }
}
