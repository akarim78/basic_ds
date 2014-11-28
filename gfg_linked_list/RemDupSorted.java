public class RemDupSorted{
	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 0; i< 10; i++){
			if(i%3 == 0) {
				list.addToTail(i);
			}
			list.addToTail(i);
		}
		list.print();
		LinkedList list1 = remDup(list);
		list1.print();
		//list1 = list1.addToFront(0);
		//list.print();
		//list1 = remDup(list1);
		//list1.print();
	}

	public static LinkedList remDup(LinkedList list) {
		if(list == null) return list;
		LinkedList temp = list;
		int value = temp.data;
		while(temp !=null && temp.next != null) {
			if(temp.next.data == value) {
				temp.next = temp.next.next;
			}else{
				temp = temp.next;
				value = temp.data;
			}
		}
		
		return list;
	}
	
}
