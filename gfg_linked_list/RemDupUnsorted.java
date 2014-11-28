import java.util.HashMap;

public class RemDupUnsorted {
	

	public static void main(String args[]) {
		LinkedList list = new LinkedList(12);
		list.addToTail(12);
		list.addToTail(11);
		list.addToTail(12);
		list.addToTail(21);
		list.addToTail(41);
		list.addToTail(43);
		list.addToTail(21);
		list.addToTail(12);
		list.addToTail(21);
		list.addToTail(21);
		list.print();

		LinkedList list1 = remDup(list);
		if(list1 != null) list1.print();
	}

	public static LinkedList remDup(LinkedList list) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(list == null) return list;
		LinkedList temp = list;
		map.put(temp.data, 1);
		while(temp !=null && temp.next != null) {
			if(map.containsKey(temp.next.data)) {
				temp.next = temp.next.next;
			} else{
				//temp = temp.next;
				map.put(temp.next.data, 1);
				temp = temp.next;
			}
		}
		
		return list;
	}
}
