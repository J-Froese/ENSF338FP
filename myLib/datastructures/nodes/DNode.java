package myLib.datastructures;

public class DNode {
	private int data;
	private DNode next = null;
	private DNode prev = null;
	public DNode(int i) {
		this.data = i;
	}
	public DNode(int i, DNode node) {
		this.data = i;
		this.next = node;
	}
	public int getData() {return this.data;}
	public DNode getNext() {return this.next;}
	public DNode getPrev() {return this.prev;}
	public void setData(int i) {this.data=i;}
	public void setNext(DNode node) {this.next = node;}
	public void setPrev(DNode node) {this.prev = node;}
}