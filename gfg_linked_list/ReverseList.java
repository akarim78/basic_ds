public class ReverseList {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();
		LinkedList rev = reverse(list);
		rev.print();

		rev = reverseRec(rev);
		rev.print();

	}

	public static LinkedList reverse(LinkedList list) {
		LinkedList current = list;
		LinkedList prev = null;
		LinkedList nextNode = null;

		while(current != null) {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		return prev;

	}

	public static LinkedList reverseRec(LinkedList list) {
		if(list == null) return null;
		if(list.next == null) return list;
		
		LinkedList ll = reverseRec(list.next);
		list.next = null;
		LinkedList temp = ll;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = list;
		return ll;
	}
}
