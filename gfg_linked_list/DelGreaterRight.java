public class DelGreaterRight {
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList(12);
		list.addToTail(15); list.addToTail(10); list.addToTail(11); list.addToTail(5);
		list.addToTail(6);  list.addToTail(2);  list.addToTail(3);
		list.print();
		LinkedList list1 = delGreaterRight(list);
		list1.print();
	}

	public static LinkedList reverse(LinkedList list) {
		LinkedList current = list;
		LinkedList next = null;
		LinkedList prev = null;

		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next; 
		}

		return prev;
	}

	public static LinkedList delGreaterRight(LinkedList list) {
		LinkedList current = reverse(list);
		LinkedList rev = current;
		rev.print();
		
		int maxSoFar = rev.data;
		while(rev != null && rev.next != null) {
			if(rev.next.data < maxSoFar) {
				rev.next = rev.next.next;
			} else{
				maxSoFar = rev.next.data;
				rev = rev.next;
			}
		}

		return reverse(current);
	}
}
