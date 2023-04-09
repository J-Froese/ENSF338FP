package myLib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    public TNode() {
        this.data = 0;
        this.balance = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        this.parent = P;
        this.left = L;
        this.right = R;

    }

    /**
     * Setter methods that will 
     * @param data updates data member to new data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @param left updates left member to new left
     */
    public void setLeft(TNode left) {
        this.left = left;
    }

    /**
     * @param right updates right member to new right
     */
    public void setRight(TNode right) {
        this.right = right;
    }

    /**
     * @param parent updates parent member to new parent
     */
    public void setParent(TNode parent) {
        this.parent = parent;
    }

    /**
     * @param balance updates balance member to new balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Getter methods
     * @return data
     */
     public int getData() {
        return this.data;
     }

    /**
     * @return left
     */
     public TNode getLeft() {
        return this.left;
     }

    /**
     * @return right
     */
     public TNode getRight() {
        return this.right;
     }

    /**
     * @return parent
     */
     public TNode getParent() {
        return this.parent;
     }

     /**
     * @return balance
     */
     public int getBalance() {
        return this.balance;
     }


     public void print() {
        System.out.println("Node Information:\ndata - " + this.data + "\n" 
                            + "left node data - " + this.left.data + "\n" 
                            + "parent node data- " + this.parent.data + "\n" 
                            + "right node data - " + this.right.data + "\n"
                            + "balance - " + this.balance);
     }

     public String toString() {
        return Integer.toString(this.data);
     }
}
