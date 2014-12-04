public class SegEvenOdd {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(17);
		list.addToTail(15); list.addToTail(8); list.addToTail(12); list.addToTail(10);
		list.addToTail(5);  list.addToTail(4); list.addToTail(1); list.addToTail(7);
		list.addToTail(6);
		list.print();

		LinkedList list1 = segEvenOdd(list);
		list1.print();
	}

	public static LinkedList segEvenOdd(LinkedList l) {
		LinkedList list = l;
		LinkedList odd = new LinkedList(-1);
		LinkedList tail = odd;

		// odd nodes in start
		while(list != null && (list.data % 2) == 1) {
			LinkedList temp = list;
			//temp.next = null; 
			tail.next = temp;
			tail = tail.next;
			list = list.next;
		}

		LinkedList current = list;
		while(current != null && current.next != null) {
			if(current.next.data%2 == 1) {
				LinkedList n = current.next;
				//n.next = null;
				tail.next = n;
				current.next = current.next.next;
			} else{
				current = current.next;
			}
		}
		
		if(current != null)	
			current.next = odd.next;
		else 
			current = odd.next;
		return list;
	}

}
