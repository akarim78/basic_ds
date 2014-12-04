public class SplitAlternate {
	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();
		splitAlternate(list);
	
	}

	public static void splitAlternate(LinkedList list) {
		LinkedList a = new LinkedList(0);
		LinkedList b = new LinkedList(0);
		LinkedList current = list;

		LinkedList x = a;
		LinkedList y = b;
		int i = 0;
		while(current != null) {
			LinkedList temp = current.next;
			if(i%2 == 0) {
				current.next = null;
				a.next = current;
				a = a.next;
			} else {
				current.next = null;
				b.next = current;
				b = b.next;
			}	
			i++;
			current = temp;
		}
		x.next.print();
		y.next.print();

	}
}
