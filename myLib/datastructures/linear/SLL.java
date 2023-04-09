package myLib.datastructures.linear;
import myLib.datastructures.nodes.DNode;

public class SLL {
	protected DNode head = null;
	protected DNode tail = null;
	protected int len = 0;
	protected boolean sort = true;

	/**This is a Singly Linked List Data structure that will implement the following:
	- Uses a head object of the base class Node (to be implemented as part of the base classes
	mentioned previously) and a tail object to keep track of the end of the list 
	- Has an integer member variable to keep track of the size of the List (update when necessary)**/
	public SLL() {}
	public SLL(DNode node) {
		this.head = node;
		this.tail = node;
		this.len=1;
	}
	/**- InsertHead(node)
	o Inserts node object at head of the list**/
	public void InsertHead(DNode node) {
		node.setNext(this.head);
		this.head = node;
		this.len+=1;
		this.sort=false;
		if (this.len==1) {
			this.tail = node;
		}
	}
	/**- InsertTail(node)
	o Inserts node object at the tail of the list**/
	public void InsertTail(DNode node) {
		if(this.tail!=null) {this.tail.setNext(node);}
		this.tail = node;
		this.len+=1;
		this.sort=false;
		if (this.len==1) {
			this.head = node;
		}
	}
	/**- Insert(node,position)
	o Inserts node object in the specified position
	▪ Ex. Insert(node ,5) → inserts node to 5th position in list**/
	public void Insert(DNode node, int pos) {
		if (pos > this.len) {
			InsertTail(node);
			return;
		} else if (pos <= 1) {
			InsertHead(node);
			return;
		}
		DNode prev = this.head;
		DNode next = this.head.getNext();
		for (int i=1; i<pos; i++) {
			prev = next;
			next = prev.getNext();
		}
		prev.setNext(node);
		node.setNext(next);
		this.len+=1;
		this.sort=false;
	}
	/**- SortedInsert(node)
	o Inserts node object in its proper position in a sorted list
	o Must check for list sort validity
	▪ If list is found to be out of order, it must call the sort function first before
	inserting
	▪ Note that you should only execute sort if the list is found to be out of order
	to avoid slowing down the insertion by executing sorting every time you
	insert
	▪ Might need to implement a helper function isSorted(), or find a creative
	way to know if the list is sorted**/
	public void SortedInsert(DNode node) {
		if (!this.sort) {
			Sort();
		}
		int n = node.getData();
		if (n < this.head.getData()) {
			InsertHead(node);
		} else if (n > this.tail.getData()) {
			InsertTail(node);
		} else {
			DNode crnt = this.head;
			DNode next = this.head.getNext();
			while (next.getData() < n) {
				crnt = next;
				next = next.getNext();
			}
			crnt.setNext(node);
			node.setNext(next);
			this.len+=1;
		}
		this.sort = true;
	}
	/**- Search(node)
	o Looks up node in the list
	▪ If found it returns the object
	▪ Otherwise returns null**/
	public DNode Search(DNode node) {
		DNode pos = this.head;
		while (pos!=null) {
			if (pos == node) {
				return pos;
			}
			pos=pos.getNext();
		}
		return null;
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
			DNode prev = this.head;
			DNode next = this.head.getNext();
			while (next != this.tail) {
				prev = next;
				next = prev.getNext();
			}
			prev.setNext(null);
			this.tail = prev;
			this.len-=1;
		}
	}
	/**- Delete(node)
	o Deletes the node if found in the list**/
	public void Delete(DNode node) {
		if(this.len <= 1 && this.head == node){
			this.head = null;
			this.tail = null;
			this.len = 0;
		} else {
			if (node == this.head) {
				DeleteHead();
				return;
			} else if (node == this.tail) {
				DeleteTail();
				return;
			}
			DNode prev = this.head;
			DNode next = this.head.getNext();
			while (next != node && next != this.tail) {
				prev = next;
				next = prev.getNext();
			}
			if (next != node) {
				return;
			}
			prev.setNext(next.getNext());
			this.tail = prev;
			this.len-=1;
		}
	}
	/**- Sort()
	o Applies insertion sort to the list
	o The insertion part will start from the head unlike the usual insertion sort algorithm
	▪ Instead of tracking back the list
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
				this.head.setNext(null);
				this.head = this.tail;
				this.tail = this.head.getNext();
			}
			this.sort = true;
			return;
		}
		while (!this.sort) {
			this.sort = true;
			if(this.head.getData() > this.head.getNext().getData()) {
				this.sort = false;
				DNode temp = this.head.getNext();
				this.head.setNext(temp.getNext());
				temp.setNext(this.head);
				this.head = temp;
			}
			DNode prev = this.head;
			DNode crnt = prev.getNext();
			DNode next = crnt.getNext();
			while (next!=null) {
				if (next.getData() < crnt.getData()) {
					this.sort = false;
					DNode temp = next.getNext();
					prev.setNext(next);
					next.setNext(crnt);
					crnt.setNext(temp);
					next = crnt;
					crnt = prev.getNext();
				}
				prev = crnt;
				crnt = next;
				next = next.getNext();
			}
			this.tail = crnt;
		}
	}
	/**- Clear()
	o Deletes the whole list**/
	public void Clear() {
		if(this.len <= 1){
			this.head = null;
			this.tail = null;
			this.len = 0;
		} else {
			DNode prev = this.head;
			DNode next = this.head.getNext();
			while (next != this.tail) {
				prev = next;
				next = prev.getNext();
				prev.setNext(null);
			}
			next.setNext(null);
			this.tail = null;
			this.len = 0;
		}
	}
	/**- Print()
	o Prints the list information on the screen, this includes
	▪ List length
	▪ Sorted status
	▪ List content
	▪ Make sure to show information with relevant print statements to be
	readable by the user**/
	public void Print() {
		System.out.println("List Length: "+this.len+"\nSorted Status: "+this.sort+"\n List Content:");
		DNode pos = this.head;
		for (int i=1; i<this.len+1&&pos!=null; i++) {
			System.out.println("Position: "+i+"\tContent: "+pos.getData());
			pos = pos.getNext();
		}
	}
}