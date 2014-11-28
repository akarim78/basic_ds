public class TailToFront {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();
		LinkedList list1 = lastToFirst(list);
		list1.print();
	}

	public static LinkedList lastToFirst(LinkedList list) {
		if(list == null) return list;

		LinkedList temp = list;
		LinkedList prev = null;
		while(temp != null) {
			if(temp.next == null) {
				temp.next = list;
				prev.next = null;
				return temp;
				
			} else{
				prev = temp;
				temp = temp.next;
			}
		}
		return list;

	}
}
