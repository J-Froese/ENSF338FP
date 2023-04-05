package myLib.datastructures;

public class StackLL extends SLL {
	
	public StackLL(DNode node) {
		this.head = node;
		this.tail = node;
		this.len=1;
	}
	
	public void push(DNode node) {
		super.InsertHead(node);
	}
	
	public DNode pop() {
		super.DeleteHead();
	}
	
	public DNode top() {
		return this.head;
	}
	
	public int size() {
		return this.len;
	}
	/**Empty overrides**/
	public void InsertTail(DNode node) {}
	public void DeleteTail() {}
	public void Insert(DNode node, int pos) {}
	public void SortedInsert(DNode node) {}
	public void Delete(DNode node) {}
	public void Sort() {}
}