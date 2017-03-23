/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Tobias
 */
public class Test
{
    public static void main(String[] args)
    {
        TreeInterface<Integer, String> tree = new Tree<>();
        tree.put(6, "F");
        tree.put(3, "C");
        tree.put(15, "O");
        tree.put(4, "E");
        tree.put(10, "J");

        RedBlackNode<Integer, String> root = tree.getRoot();
        System.out.println(tree.get(10, root));
    }
}
