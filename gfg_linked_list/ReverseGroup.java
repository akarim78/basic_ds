public class ReverseGroup {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();
		LinkedList res = reverse(list, 3);
		res.print();
	}

	public static LinkedList reverse(LinkedList list, int k) {
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

		if(next != null) list.next = reverse(next, k);

		return prev;
	}

}
