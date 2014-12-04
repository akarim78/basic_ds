public class IntersectionList {

	public static void main(String args[]) {
		LinkedList list1 = new LinkedList(1);
		list1.addToTail(2); list1.addToTail(3); list1.addToTail(4); list1.addToTail(6);
		list1.print();
		LinkedList list2 = new LinkedList(2);
                list2.addToTail(4); list2.addToTail(6); list2.addToTail(8);
                list2.print();

		LinkedList list = getIntersection(list1, list2);
		list.print();
		
		LinkedList l = intersectRec(list1, list2);
		l.print();
	}

	public static LinkedList intersectRec(LinkedList l1, LinkedList l2) {
		if(l1 == null || l2 == null) return null;
		if(l1.data < l2.data) return intersectRec(l1.next, l2);
		if(l1.data > l2.data) return intersectRec(l1, l2.next);
		LinkedList temp = new LinkedList(l1.data);
		temp.next = intersectRec(l1.next, l2.next);
		return temp;
	}

	public static LinkedList getIntersection(LinkedList l1, LinkedList l2) {
		LinkedList dummy = new LinkedList(0);
		LinkedList tail = dummy;

		while(l1 != null && l2 !=null) {
			if(l1.data == l2.data) {
				LinkedList node = new LinkedList(l1.data);
				tail.next = node;
				tail = tail.next;
				l1 = l1.next;
				l2 = l2.next;
			}
			else if(l1.data < l2.data) {
				l1 = l1.next;
			}
			else if(l1.data > l2.data) {
				l2 = l2.next;
			}

		}

		return dummy.next;
	}
}
