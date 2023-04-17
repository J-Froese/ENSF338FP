package myLib.test;

import myLib.datastructures.nodes.TNode;
import myLib.datastructures.trees.AVL;
import myLib.datastructures.trees.BST;

public class Module2 {
    public static void main(String[] args) {
         BST bst = new BST(new TNode(31, 0, null, null, null));
        bst.Insert(5);
        bst.Insert(7);
        bst.Insert(1);
        bst.printInOrder();
        System.out.println();
        bst.Delete(7);
        bst.printInOrder();
        System.out.println();
        bst.Insert(10);
        bst.Insert(11);
        bst.printInOrder();
        System.out.println();
        bst.printBF();


        AVL avl = new AVL(new TNode(1, 0, null, null, null));
        avl.Insert(1);
        avl.Insert(3);
        avl.Delete(1);
        avl.printInOrder();

    }
}
