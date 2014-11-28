public class DeleteAlternate {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();
		LinkedList list1 = deleteAlternate(list);
		list1.print();
	}

	public static LinkedList deleteAlternate(LinkedList list) {
		if(list == null) return list;
		LinkedList temp = list;

		while(temp != null && temp.next != null) {
			temp.next = temp.next.next;
			temp = temp.next;

		}

		return list;

	}
}
