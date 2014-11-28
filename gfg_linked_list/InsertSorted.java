public class InsertSorted {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();

		LinkedList list1 = insertData(list, 5);
		list1.print();
		list1 = insertData(list1, 100);
		list1.print();
		list1 = insertData(list1, -1);
		list1.print();
	}

	public static LinkedList insertData(LinkedList list, int data) {
		LinkedList temp = list;

		if(temp == null) return new LinkedList(data);
		if(data < temp.data) {
			LinkedList node = new LinkedList(data);
			node.next = list;
			return node; 
		} 
		LinkedList node = new LinkedList(data);
		while(temp.next != null) {
			if(temp.next.data > data) {
				node.next = temp.next;
				temp.next = node;
				return list;
			} 
			temp = temp.next;
		}
		temp.next = node;
		return list;
	}

}
