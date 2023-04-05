package myLib.datastructures;

public class CSLL extends SLL {

	public CSLL(DNode node) {
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
		if (this.len=1) {
			this.tail = node;
		} else {
			this.tail.setNext(this.head);
		}
	}
	/**- InsertTail(node)
	o Inserts node object at the tail of the list**/
	public void InsertTail(DNode node) {
		this.tail.setNext(node);
		this.tail = node;
		this.len+=1;
		this.sort=false;
		if (this.len=1) {
			this.head = node;
		} else {
			this.tail.setNext(this.head);
		}
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
	public void SortedInsert(node) {
		if (!this.sort) {
			Sort();
		}
		int n = node.getData();
		 
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
			DNode prev = this.head;
			DNode next = this.head.getNext();
			while (next != this.tail) {
				prev = next;
				next = prev.getNext();
			}
			prev.setNext(this.head);
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
				this.head.setNext(this.tail);
				this.head = this.tail;
				this.tail = this.head.getNext();
			}
			this.sort = true;
			return;
		}
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			DNode prev = this.head;
			DNode crnt = prev.getNext();
			DNode next = crnt.getNext();
			while (next!=this.head) {
				if (next.getData() < crnt.getData()) {
					sorted = false;
					DNode temp = next.getNext();
					prev.setNext(next);
					next.setNext(crnt);
					crnt.setNext(temp);
					next = crnt;
					crnt = prev.getNext();
				}
				prev = prev.getNext();
				crnt = crnt.getNext();
				next = next.getNext();
			}
		}
	}
}