package myLib.datastructures.linear;//Fix

public class SLL {
	private DNode head = null;
	private DNode tail = null;
	private int len = 0;

	/**This is a Singly Linked List Data structure that will implement the following:
	- Uses a head object of the base class Node (to be implemented as part of the base classes
	mentioned previously) and a tail object to keep track of the end of the list 
	- Has an integer member variable to keep track of the size of the List (update when necessary)**/
	public SLL(DNode node) {
		this.head = node;
		this.tail = node;
		this.len=1;
	}
	/**- InsertHead(node)
	o Inserts node object at head of the list**/
	public void insertHead(DNode node) {
		node.setNext(this.head);
		this.head = node;
		this.len+=1;
	}
	/**- InsertTail(node)
	o Inserts node object at the tail of the list**/
	public void insertTail(DNode node) {
		this.tail.setNext(node);
		this.tail = node;
		this.len+=1;
	}
	/**- Insert(node,position)
	o Inserts node object in the specified position
	▪ Ex. Insert(node ,5) → inserts node to 5th position in list**/
	public void insert(DNode node, int pos) {
		if (pos > this.len) {
			insertTail(node);
			return;
		} else if (pos <= 1) {
			insertHead(node);
			return;
		}
		DNode prev = this.head;
		dNode next = this.head.getNext();
		for (int i=1; i<pos; i++) {
			prev = next;
			next = prev.getNext();
		}
		prev.setNext(node);
		node.setNext(next);
		this.len+=1;
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
	way to know if the list is sorted

	- Search(node)
	o Looks up node in the list
	▪ If found it returns the object
	▪ Otherwise returns null**/
	public DNode search(DNode node) {
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
	public void deleteHead() {
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
	public void deleteTail() {
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
	public void delete(DNode note) {
		if(this.len <= 1){
			this.head = null;
			this.tail = null;
			this.len = 0;
		} else {
			if (node == this.head) {
				deleteHead();
				return;
			} else if (node == this.tail) {
				deleteTail();
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
	reduce code redundancy (not mandatory)

	- Clear()
	o Deletes the whole list**/
	public void clear() {
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
}