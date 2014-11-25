public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList head = new LinkedList(1);
		for(int i = 2; i < 10; i++) {
			head.addToTail(i);			
		}

		head.addToTail(2);
		head.print();

		head = head.addToFront(0);
		head.print();

		head = head.insertAt(4, 10);
		head.print();

		head = head.insertAt(0, 11);
		head.print();

		head = head.remove(0);
		head.print();

		head = head.removeAll(2);
		head.print();

		head = head.remove(11);
		head.print();

		LinkedList node = head.getNode(5);
		node.print();

		System.out.println("Length of the list: " + head.getLength());
		System.out.println("Count of 2: " + head.getElementCount(2));
		head.addToTail(6);
		head.addToTail(6);
		System.out.println("Count of 6: " + head.getElementCount(6));
	}
}
