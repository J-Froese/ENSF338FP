package myLib.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import myLib.datastructures.linear.CSLL;
import myLib.datastructures.nodes.TNode;
import myLib.datastructures.trees.AVL;
import myLib.datastructures.trees.BST;


/**
 * Running all the main program here
 */
public class Mod2Testing {
    @Test
    public void checkTNodeTest() {
        TNode n = new TNode(1, 1, null, null, null);
        int balance = n.getBalance();
        int data = n.getData();
        assertEquals(balance, 1);
        assertEquals(data, 1);
        
        TNode m = new TNode(1, 2, new TNode(1, 1, null, null, null), new TNode(1, 1, null, null, null), new TNode(1, 1, null, null, null));
        boolean passed = true;
        try {
            m.print();
        } catch(Exception e) {
            passed = false;
        }
        assertTrue("The TNode print method did not work successfully", passed);   
    }

    @Test
    public void checkBSTTest() {
        boolean passed = true;
        try {
            BST bst = new BST(2);
            bst.Insert(5);
            bst.Insert(7);
            bst.Insert(1);
            bst.Insert(9);
            bst.Delete(10);
            bst.printInOrder();
            bst.printBF();
            bst.Search(1);
        } catch(Exception e) {
            passed = false;
        }
        assertTrue("Some errors were found in the BST functionality", passed);

        try {
            BST bst = new BST(new TNode(3, 1, new TNode(9, 0, null, null, null), new TNode(4, 0, null, null, null), new TNode(1, 0, null, null, null)));
            bst.Insert(20);
            bst.Insert(9);
            bst.Delete(6);
            bst.printInOrder();
            bst.printBF();
            bst.Search(1);
        } catch(Exception e) {
            passed = false;
        }
        assertTrue("Some errors were found in the BST functionality", passed);
    }

    @Test
    public void checkAVLTest() {
        boolean passed = true;
        try {
            AVL avl = new AVL(2);
            avl.Insert(5);
            avl.Insert(7);
            avl.Insert(1);
            avl.Insert(9);
            avl.Delete(10);
            avl.Search(1);
        } catch(Exception e) {
            passed = false;
        }
        assertTrue("Some errors were found in the AVL functionality", passed);

        try {
            AVL avl = new AVL(new TNode(3, 1, new TNode(9, 0, null, null, null), new TNode(4, 0, null, null, null), new TNode(1, 0, null, null, null)));
            avl.Insert(5);
            avl.Insert(7);
            avl.Insert(1);
            avl.Delete(10);
            avl.Search(1);
        } catch(Exception e) {
            passed = false;
        }

        assertTrue("Some errors were found in the AVL functionality", passed);
    }
}
