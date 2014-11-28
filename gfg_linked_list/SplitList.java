public class SplitList {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();
		splitList(list);
	}

	public static void splitList(LinkedList list) {
		if(list == null) return;
		LinkedList temp = list;

		while(temp != null && temp.next != null) {

		}

	}
}
