package myLib.datastructures.linear;
import myLib.datastructures.nodes.DNode;

public class StackLL extends SLL {
	
	public StackLL(DNode node) {
		super(node);
	}
	
	public void push(DNode node) {
		super.InsertHead(node);
	}
	
	public DNode pop() {
		DNode rtrn = this.head;
		super.DeleteHead();
		return rtrn;
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