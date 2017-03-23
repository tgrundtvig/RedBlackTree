package algorithms;

import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        BSTInterface<Integer, String> myTree = new RedBlackBST<Integer, String>(Comparator.naturalOrder());
        myTree.put(13, "L");
        myTree.put(8, "K");
        myTree.put(17, "Z");
        myTree.put(27, "A");
        myTree.put(22, "J");
        myTree.put(15, "W");
        myTree.put(11, "P");
        myTree.put(25, "T");
        myTree.put(1, "D");
        myTree.put(6, "S");

        RedBlackNode<Integer, String> root = myTree.getRoot();
        System.out.println(myTree.get(8, root));
    }
}
