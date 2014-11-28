public class LoopDetect {
	
	public static void main(String args[]) {
		LinkedList head = new LinkedList(0);
		for(int i = 1; i < 8; i++) {
			head.addToTail(i);
		}

		System.out.println("Loop Exists: " + loopExists(head));
		LinkedList node = head.getNode(3);
		LinkedList temp = head;
		while(temp.next != null)
			temp = temp.next;

		temp.next = node;

		System.out.println("Loop Exists: " + loopExists(head));
	

	}

	public static boolean loopExists(LinkedList list) {
		LinkedList slow = list;
		LinkedList fast = list;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
		return false;
	}

}
