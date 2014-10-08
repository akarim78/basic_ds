/*
 * LinkedList reversal ch3 prob2
 */

public class LinkedListReverse {

	public static void main(String args[]) {
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);     
		n.appendToTail(4);     
		n.appendToTail(5);     
		n.appendToTail(6);     
		n.appendToTail(7); 
		System.out.println(n.toString());
		Node p = reverse(n);
		System.out.println(p.toString());    

	}

	public static Node reverse(Node n) {
		if(n == null || n.next == null) return n;

		Node remaining = reverse(n.next);
		Node temp = remaining;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = n;
		n.next = null;
		return remaining;
	}
	
}
