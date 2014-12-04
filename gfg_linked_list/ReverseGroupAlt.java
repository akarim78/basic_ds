public class ReverseGroupAlt {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();
		LinkedList res = kAltReverse(list, 3);
		res.print();
	}

	public static LinkedList kAltReverse(LinkedList list, int k) {
		LinkedList current = list;
		LinkedList prev = null;
		LinkedList next = null;

		int count = 0;
		while(current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		// head k to k+1
		if(list != null) list.next = current;

		count = 0;
		while(current != null && count < k-1) {
			current = current.next;
			count++;
		}	

		if(current != null) current.next = kAltReverse(current.next, k);
		return prev;
	}

}
