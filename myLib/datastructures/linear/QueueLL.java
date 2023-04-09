package myLib.datastructures.linear;
import myLib.datastructures.nodes.DNode;

public class QueueLL extends SLL {
	
	public QueueLL() {}
	public QueueLL(DNode node) {
		super(node);
	}
	
	public void enque(DNode node) {
		super.InsertTail(node);
	}
	
	public DNode deque() {
		DNode rtrn = this.head;
		super.DeleteHead();
		return rtrn;
	}
	
	public DNode front() {
		return this.head;
	}
	
	public DNode back() {
		return this.tail;
	}
	
	public int size() {
		return this.len;
	}
	/**Empty overrides**/
	public void InsertHead(DNode node) {}
	public void DeleteTail() {}
	public void Insert(DNode node, int pos) {}
	public void SortedInsert(DNode node) {}
	public void Delete(DNode node) {}
	public void Sort() {}
}