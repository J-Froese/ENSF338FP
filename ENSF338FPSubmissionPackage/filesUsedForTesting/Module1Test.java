import myLib.datastructures.linear.*;
import myLib.datastructures.nodes.*;

public class Module1Test {
	public static void main(String[] args) {
		DNode nOne = new DNode(1);//SLLS
		SLL sOne = new SLL(nOne);
		CSLL sTwo = new CSLL();
		for (int i=0; i<10; i+=2) {
			sOne.InsertHead(new DNode(i));
			sTwo.InsertHead(new DNode(i));
		}
		System.out.println("\nSLLs");
		sOne.Print();
		sTwo.Print();
		sOne.Sort();
		sTwo.SortedInsert(new DNode(3));
		System.out.println();
		sOne.Print();
		sTwo.Print();
		sOne.DeleteHead();
		sTwo.DeleteTail();
		System.out.println();
		sOne.Print();
		sTwo.Print();
		
		DNode nTwo = new DNode(2);//DLLS
		DLL dOne = new DLL(nTwo);
		CDLL dTwo = new CDLL();
		for (int i=0; i<15; i+=3) {
			dOne.InsertHead(new DNode(i));
			dTwo.InsertHead(new DNode(i));
		}
		System.out.println("\nDLLS");
		dOne.Print();
		dTwo.Print();
		dOne.Sort();
		dTwo.SortedInsert(new DNode(7));
		System.out.println();
		dOne.Print();
		dTwo.Print();
		dOne.DeleteHead();
		dTwo.DeleteTail();
		System.out.println();
		dOne.Print();
		dTwo.Print();
		
		StackLL s = new StackLL(new DNode(4));
		QueueLL q = new QueueLL();
		for (int i=0; i<10; i++) {
			s.push(new DNode(i*2));
			q.enque(new DNode(i*3));
		}
		System.out.println("\nS&Q");
		s.Print();
		q.Print();
		System.out.println(s.pop());
		System.out.println(q.deque());
		System.out.println();
		s.Print();
		q.Print();
		s.DeleteHead();
		q.DeleteTail();
		System.out.println();
		s.Print();
		q.Print();
	}
}