public class NthNodeFromTail {

	public static void main(String args[]) {
		LinkedList list = new LinkedList(0);
		for(int i = 1; i < 10; i++) {
			list.addToTail(i);
		}
		list.print();
		LinkedList nth = getNthFromTail(list, 5);
		nth.print();
	}

	public static LinkedList getNthFromTail(LinkedList head, int n) {
		LinkedList fast = head;
		LinkedList slow = head;
		int count = 0;
		while(count < n && fast != null) {
			count++;
			fast = fast.next;
		}

		// n > length
		//if(count < n) return slow;

		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
