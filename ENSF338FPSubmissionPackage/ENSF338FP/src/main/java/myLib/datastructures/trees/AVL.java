package myLib.datastructures.trees;
import java.util.ArrayList;
import myLib.datastructures.nodes.TNode;

public class AVL extends BST{
    private TNode root;

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public AVL(TNode obj) {
        this.root = obj;
        if(obj.getLeft() != null && obj.getRight() != null) {
            this.root = new TNode(obj.getData(), 0, null, null, null);
        } else {
            this.root = balancedTree(obj);
        }
    }

    /**
     * Setters and Getters
     */
    public void setRoot(TNode node) {
        this.root = node;
        if(node.getLeft() != null || node.getRight() != null) {
            this.root = balancedTree(node);
        }
    }

    public TNode getRoot() {
        return this.root;
    }
    /**
     * Helper functions
     */

    private TNode balancedTree(TNode node) {
        ArrayList<Integer> sorted = new ArrayList<>();
        orderTraversal(node, sorted);
        return balancedTreeHelper(sorted, 0, sorted.size()-1);
    }

    private TNode balancedTreeHelper(ArrayList<Integer> sorted, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = start + (end-start) / 2;
        TNode node = new TNode(sorted.get(mid), 0, null, null, null);
        node.setLeft(balancedTreeHelper(sorted, start, mid-1));
        node.setRight(balancedTreeHelper(sorted, mid+1, end));
        return node;
    }

    private void orderTraversal(TNode node, ArrayList<Integer> sorted) {
        if(node == null) {
            return;
        }
        sorted.add(node.getData());
        orderTraversal(node.getRight(), sorted);
    }

    private TNode insertHelper(TNode node, int val) {
        if(node == null) {
            return new TNode(val, 0, null, null, null);
        } 
        if(val < node.getData()) {
            node.setLeft(insertHelper(node.getLeft(), val));
        } else if(val > node.getData()) {
            node.setRight(insertHelper(node.getRight(), val));
        } else {
            return node;
        }
        int balance = getBalance(node);
        if(balance > 1 && val < node.getLeft().getData()) {
            return rotateRight(node);
        }
        if(balance < -1 && val > node.getRight().getData()) {
            return rotateLeft(node);
        }
        if(balance > 1 && val > node.getLeft().getData()) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if(balance < -1 && val < node.getRight().getData()) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        return node;
       
    }
    /*insert and delete */
    @Override
    public void Insert(int val) {
        this.root = insertHelper(this.root, val);
    }

    @Override
    public void Insert(TNode node) {
        this.root = insertHelper(this.root, node.getData());
    }

    @Override
    public void Delete(int val) {
        this.root = deleteNode(this.root, val);
    }

    private TNode deleteNode(TNode node, int val) {
        if(node == null) {
            System.out.println("Unfortunately, this value could not be found in the tree");
            return null;
        } 
        if(val < node.getData()) {
            node.setLeft(deleteNode(node.getLeft(), val));
        } else if(val > node.getData()) {
            node.setRight(deleteNode(node.getRight(), val));
        } else {
            if(node.getLeft() == null || node.getRight() == null) {
                TNode temp = null;
                if(temp == node.getLeft()) {
                    temp = node.getRight();
                } else {
                    temp = node.getLeft();
                }
                if(temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                TNode temp = minValueNode(node.getRight());
                node.setData(temp.getData());
                node.setRight(deleteNode(node.getRight(), temp.getData()));
            }
        }
        if(node == null) {
            return null;
        }
        int balance = getBalance(node);
        if(balance > 1 && getBalance(node.getLeft()) >= 0) {
            return rotateRight(node);
        }
        if(balance > 1 && getBalance(node.getLeft()) < 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if(balance < -1 && getBalance(node.getRight()) <= 0) {
            return rotateLeft(node);
        }
        if(balance < -1 && getBalance(node.getRight()) > 0) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        return node;
    }

    private TNode rotateRight(TNode y) {
        TNode x = y.getLeft();
        TNode temp = x.getRight();
        x.setRight(y);
        y.setLeft(temp);
        return x;
    }

    private TNode rotateLeft(TNode x) {
        TNode y = x.getRight();
        TNode temp = y.getLeft();
        y.setLeft(x);
        x.setRight(temp);
        return y;
    }

    private int height(TNode node) {
        if(node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        }
    }

    private int getBalance(TNode node) {
        if(node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }


    private TNode minValueNode(TNode node) {
        TNode current = node;
        while(current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public TNode Search(int val) {
        return super.Search(val);
    }
    public void printInOrder() {
        super.printInOrder();
    }

    public void printBF() {
        super.printBF();
    }
}