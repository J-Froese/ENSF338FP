package myLib.datastructures.linear;import myLib.datastructures.nodes.DNode;public class DLL extends SLL {		public DLL() {}	public DLL(DNode node) {		super(node);	}	/**- InsertHead(node)	o Inserts node object at head of the list**/	public void InsertHead(DNode node) {		node.setNext(this.head);		node.setPrev(null);		if(this.head!=null) {this.head.setPrev(node);}		this.head = node;		this.len+=1;		this.sort=false;		if (this.len==1) {			this.tail = node;		}	}	/**- InsertTail(node)	o Inserts node object at the tail of the list**/	public void InsertTail(DNode node) {		node.setPrev(this.tail);		node.setNext(null);		if(this.tail!=null) {this.tail.setNext(node);}		this.tail = node;		this.len+=1;		this.sort=false;		if (this.len==1) {			this.head = node;		}	}	/**- Insert(node,position)	o Inserts node object in the specified position	? Ex. Insert(node ,5) ? inserts node to 5th position in list**/	public void Insert(DNode node, int pos) {		if (pos > this.len) {			InsertTail(node);			return;		} else if (pos <= 1) {			InsertHead(node);			return;		}		DNode prev = this.head;		DNode next = this.head.getNext();		for (int i=1; i<pos; i++) {			prev = next;			next = prev.getNext();		}		prev.setNext(node);		node.setPrev(prev);		node.setNext(next);		next.setPrev(node);		this.len+=1;		this.sort=false;	}	/**- SortedInsert(node)	o Inserts node object in its proper position in a sorted list	o Must check for list sort validity	? If list is found to be out of order, it must call the sort function first before	inserting	? Note that you should only execute sort if the list is found to be out of order	to avoid slowing down the insertion by executing sorting every time you	insert	? Might need to implement a helper function isSorted(), or find a creative	way to know if the list is sorted**/	public void SortedInsert(DNode node) {		if (!this.sort) {			Sort();		}		int n = node.getData();		if (n < this.head.getData()) {			InsertHead(node);		} else if (n > this.tail.getData()) {			InsertTail(node);		} else {			DNode next = this.head.getNext();			while (next.getData() < n) {				next = next.getNext();			}			DNode prev = next.getPrev();			next.setPrev(node);			node.setNext(next);			node.setPrev(prev);			prev.setNext(node);			this.len+=1;		}		this.sort = true;	}	/**- DeleteHead()	o Delete head node**/	public void DeleteHead() {		if(this.len <= 1){			this.head = null;			this.tail = null;			this.len = 0;		} else {			this.head = this.head.getNext();			this.head.setPrev(null);			this.len-=1;		}	}	/**- DeleteTail()	o Delete tail node**/	public void DeleteTail() {		if(this.len <= 1){			this.head = null;			this.tail = null;			this.len = 0;		} else {			DNode prev = this.tail.getPrev();			prev.setNext(null);			this.tail = prev;		}	}	/**- Delete(node)	o Deletes the node if found in the list**/	public void Delete(DNode node) {		if(this.len <= 1 && this.head == node){			this.head = null;			this.tail = null;			this.len = 0;		} else {			if (node == this.head) {				DeleteHead();				return;			} else if (node == this.tail) {				DeleteTail();				return;			}			DNode prev = this.head;			DNode next = this.head.getNext();			while (next != node && next != this.tail) {				prev = next;				next = prev.getNext();			}			if (next != node) {				return;			}			next = next.getNext();			prev.setNext(next);			next.setPrev(prev);			this.tail = prev;			this.len-=1;		}	}	/**- Sort()	o Applies insertion sort to the list	o The insertion part will start from the head unlike the usual insertion sort algorithm	? Instead of tracking back the list	o Note that the sort method and SortedInsert can use each other to efficiently	reduce code redundancy (not mandatory)**/	public void Sort() {		if (this.len <= 1) {			this.sort = true;			return;		}		if (this.len == 2) {			if (this.head.getData() < this.tail.getData()) {				this.tail.setNext(this.head);				this.tail.setPrev(null);				this.head.setNext(null);				this.head.setPrev(this.tail);				this.head = this.tail;				this.tail = this.head.getNext();			}			this.sort = true;			return;		}		while (!this.sort) {			this.sort = true;			DNode prev = this.head;			DNode next = prev.getNext();			while (next!=null) {				if(next.getData() < prev.getData()) {					this.sort = false;					DNode tempN = next.getNext();					DNode tempP = prev.getPrev();					if (tempN != null) {tempN.setPrev(prev);}					if (tempP != null) {tempP.setNext(next);}					next.setPrev(tempP);					next.setNext(prev);					prev.setPrev(next);					prev.setNext(tempN);					if(this.head == prev) {this.head = next;}					prev = next;					next = next.getNext();				}				prev = next;				next = next.getNext();			}			this.tail = prev;		}	}	/**- Clear()	o Deletes the whole list**/	public void Clear() {		if(this.len <= 1){			this.head = null;			this.tail = null;			this.len = 0;		} else {			DNode prev = this.head;			DNode next = this.head.getNext();			while (next != this.tail) {				prev = next;				next = prev.getNext();				prev.setNext(null);			}			next.setNext(null);			this.tail = null;			this.len = 0;		}	}}