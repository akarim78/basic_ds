public class PairSwap {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 9; i++) {
			list.addToTail(i);
		}
		list.print();
		LinkedList list1 = swapPair(list);
		list1.print();
	}

	public static LinkedList swapPair(LinkedList list) {
		if(list == null) return list;
		LinkedList temp = list;
		//if(temp.next != null)
		//	list = temp.next;

		//LinkedList prev = null;
		while(temp != null && temp.next!=null){
			int t = temp.data;
			temp.data = temp.next.data;
			temp.next.data = t;
			temp = temp.next.next;
		}

		return list;
	}
}
