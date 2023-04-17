package myLib.datastructures.trees;
import myLib.datastructures.nodes.TNode;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private TNode root;

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public BST(TNode obj) {
        this.root = obj;
    }

    /**
     * Setters
     */
    public void setRoot(TNode node) {
        this.root = node;
    }

    public TNode getRoot() {
        return this.root;
    }

    /*
     * 
     */
    public void Insert(TNode node) {
        if(this.root == null) {
            this.root = node;
        } else {
            TNode current = this.root;
            while(true) {
                if(current.getData() < node.getData()) {
                    if(current.getRight() == null) {
                        current.setRight(node);
                        node.setParent(current);
                        break;
                    } else {
                        current = current.getRight();
                    }

                } else if(current.getData() > node.getData()) {
                    if(current.getLeft() == null) {
                        current.setLeft(node);
                        node.setParent(current);
                        break;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    break;
                }
            }
            
        }
    }

    /**
     * Takes advantage of the functionality of Insert(TNode node) 
     * @param val
     */
    public void Insert(int val) {
        TNode node = new TNode(val, 0, null, null, null);
        Insert(node);
    }

    public TNode Search(int val) {
        TNode current = this.root;
        while(current != null) {
            if(current.getData() == val) {
                return current;
            } else if(current.getData() > val) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    public void Delete(int val) {
        TNode deleteNode = Search(val);
        if(deleteNode == null) {
            System.out.println("The value " + val + " can not be found in the Binary Search Tree.");
            return;
        }

        if(deleteNode.getRight() == null && deleteNode.getLeft() == null) {
            if(deleteNode == this.root) {
                this.root = null;
            } else {
                TNode parent = deleteNode.getParent();
                if(deleteNode == parent.getLeft()) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
        } else if(deleteNode.getRight() == null || deleteNode.getLeft() == null) {
            TNode child;
            if(deleteNode.getLeft() != null) {
                child = deleteNode.getLeft();
            } else {
                child = deleteNode.getRight();
            }

            if(deleteNode == this.root) {
                this.root = child;
                child.setParent(null);
            } else {
                TNode parent = deleteNode.getParent();
                if(deleteNode == parent.getLeft()) {
                    parent.setLeft(child);
                } else {
                    parent.setRight(child);
                }
                child.setParent(parent);
            }
        } else {
            
            TNode successor = deleteNode.getRight();
            while(successor.getLeft() != null) {
                successor = successor.getLeft();
            }

            int temporary = deleteNode.getData();
            deleteNode.setData(successor.getData());
            successor.setData(temporary);
            Delete(successor.getData());
        }
    }

    
    public void printInOrder() {
        if(this.root == null) {
            System.out.println("Unfortunately, the Tree is Empty");
        } 
        printInOrder(this.root);
        
    }


    public void printBF() {
        if(this.root == null) {
            System.out.println("Unfortunately, this tree is empty");
        }
        Queue<TNode> q = new LinkedList<>();
        q.add(this.root);
        while(!q.isEmpty()) {
            int level = q.size();
            for(int i = 0; i < level; i++) {
                TNode node = q.poll();
                System.out.println(node.getData() + " ");
                if(node.getLeft() != null) {
                    q.add(node.getLeft());
                }
                if(node.getRight() != null) {
                    q.add(node.getRight());
                }
            }
            System.out.println();
        }
    }
    //helper function
    private void printInOrder(TNode currentNode) {
        if(currentNode == null) {
            return;
        } else {
            printInOrder(currentNode.getLeft());
            System.out.print(currentNode.getData() + " ");
            printInOrder(currentNode.getRight());
        }
    }


}