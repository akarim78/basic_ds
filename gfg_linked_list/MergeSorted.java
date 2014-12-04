public class MergeSorted {

	public static void main(String args[]) {
		LinkedList list1 = new LinkedList(1);
		list1.addToTail(5); list1.addToTail(6); list1.addToTail(9);
		list1.print();
 		
		LinkedList list2 = new LinkedList(2);
		list2.addToTail(4); list2.addToTail(7); list2.addToTail(10);
		list2.print();

		LinkedList list = merge(list1, list2);
		list.print();
	}

	public static LinkedList merge(LinkedList a, LinkedList b) {
		LinkedList dummy = new LinkedList(-1);
		LinkedList tail = dummy;

		while(a != null || b != null) {
			if(a == null || (a.data >= b.data)) {
				LinkedList temp = b.next;
				b.next = null;
				tail.next = b;
				b = temp;
				tail = tail.next;
			} else if(b == null || (a.data < b.data)) {
				LinkedList temp = a.next;
				a.next = null;
                                tail.next = a; 
                                a = temp;                                                                     
                                tail = tail.next;	
			}

		}

		return dummy.next;
	}
}
