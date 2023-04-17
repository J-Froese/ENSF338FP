package myLib.datastructures.linear;
import myLib.datastructures.nodes.DNode;

public class CDLL extends DLL {
	
	public CDLL() {}
	public CDLL (DNode node) {
		super(node);
	}
	/**- InsertHead(node)
	o Inserts node object at head of the list**/
	public void InsertHead(DNode node) {
		node.setNext(this.head);
		if(this.head!=null) {this.head.setPrev(node);}
		this.head = node;
		this.len+=1;
		this.sort=false;
		if (this.len==1) {
			this.tail = node;
		} else {
			this.tail.setNext(this.head);
			this.head.setPrev(this.tail);
		}
	}
	/**- InsertTail(node)
	o Inserts node object at the tail of the list**/
	public void InsertTail(DNode node) {
		if(this.tail!=null) {this.tail.setNext(node);}
		node.setPrev(this.tail);
		this.tail = node;
		this.len+=1;
		this.sort=false;
		if (this.len==1) {
			this.head = node;
		} else {
			this.tail.setNext(this.head);
			this.head.setPrev(this.tail);
		}
	}
	/**- DeleteHead()
	o Delete head node**/
	public void DeleteHead() {
		if(this.len <= 1){
			this.head = null;
			this.tail = null;
			this.len = 0;
		} else {
			this.head = this.head.getNext();
			this.head.setPrev(this.tail);
			this.tail.setNext(this.head);
			this.len-=1;
		}
	}
	/**- DeleteTail()
	o Delete tail node**/
	public void DeleteTail() {
		if(this.len <= 1){
			this.head = null;
			this.tail = null;
			this.len = 0;
		} else {
			DNode prev = this.tail.getPrev();
			this.tail = prev;
			this.head.setPrev(this.tail);
			this.tail.setNext(this.head);
			this.len-=1;
		}
	}
	/**- Sort()
	o Applies insertion sort to the list
	o The insertion part will start from the head unlike the usual insertion sort algorithm
	? Instead of tracking back the list
	o Note that the sort method and SortedInsert can use each other to efficiently
	reduce code redundancy (not mandatory)**/
	public void Sort() {
		if (this.len <= 1) {
			this.sort = true;
			return;
		}
		if (this.len == 2) {
			if (this.head.getData() < this.tail.getData()) {
				this.tail.setNext(this.head);
				this.tail.setPrev(null);
				this.head.setNext(null);
				this.head.setPrev(this.tail);
				this.head = this.tail;
				this.tail = this.head.getNext();
			}
			this.sort = true;
			return;
		}
		while (!this.sort) {
			this.sort = true;
			DNode prev = this.head;
			DNode next = prev.getNext();
			for (int i = this.len; i>1; i--) {
				if(next.getData() < prev.getData()) {
					this.sort = false;
					DNode tempN = next.getNext();
					DNode tempP = prev.getPrev();
					tempN.setPrev(prev);
					tempP.setNext(next);
					next.setPrev(tempP);
					next.setNext(prev);
					prev.setPrev(next);
					prev.setNext(tempN);
					prev = next;
					next = next.getNext();
				}
				prev = next;
				next = next.getNext();
			}
			this.tail = prev;
			this.head = prev.getNext();
		}
	}
}