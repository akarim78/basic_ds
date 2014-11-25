public class RemoveNode {

	public static void main(String[] args) {
		LinkedList head = new LinkedList(10);
		for(int i = 9; i >= 0; i--) {
			head.addToTail(i);
		}
		head.print();

		LinkedList node = head.getNode(5);
		node.print();

		removeNode(node);
		head.print();	
	
	}

	public static void removeNode(LinkedList node) {
		if(node.next != null) {
			//LinkedList temp = node.next;
			node.data = node.next.data;
			node.next = node.next.next;
		} else {
			node = null;
		}

	} 
} 
