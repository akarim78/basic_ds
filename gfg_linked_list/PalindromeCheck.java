public class PalindromeCheck {

	public static void main(String args[]) {
		LinkedList list1 = new LinkedList(0);
		for(int i = 1; i < 5; i++)
			list1.addToTail(i);
		list1.print();
		System.out.println("Palindrome: " + isPalindrome1(list1));
		list1.print();

		for(int i = 4; i >= 0; i--)
			list1.addToTail(i);	
		list1.print();
		System.out.println("Palindrome: " + isPalindrome1(list1));
		list1.print();

	}

	public static boolean isPalindrome1(LinkedList list1) {
		// handle trivial cases

		//-----------------
		LinkedList fast = list1;
		LinkedList slow = list1;
		LinkedList mid = null;
		LinkedList prev_slow = null;
	
		// first let's find mid
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev_slow = slow;
			slow = slow.next;
		}	
		// odd elements
		if(fast != null) {
			mid = slow;
			slow = slow.next;
		}
		
		prev_slow.next = null;
		// reverse
		LinkedList second = slow;
		LinkedList rev = reverse(second);
		boolean pal = true;
		LinkedList temp = rev;
		LinkedList list = list1;
		while(temp != null && list != null){
			if(temp.data != list.data) {
				pal = false;
			}
			temp = temp.next;
			list = list.next;
		}
		if(mid!=null) {
			prev_slow.next = mid;
			prev_slow = prev_slow.next;
		}

		rev = reverse(rev);
		prev_slow.next = rev;
		return pal;
	}

	public static LinkedList reverse(LinkedList list) {
		LinkedList current = list;
		LinkedList prev = null;
		LinkedList nextNode = null;
		while(current != null) {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}

		return prev;

	}

	public static boolean isPalindrome(LinkedList list1) {
		LinkedList list = list1;
		LinkedList mid = list.getMiddleNode();
		mid.print();
		LinkedList rev = reverse(mid);
		LinkedList temp = rev;
		while(temp != null) {
			if(list.data != temp.data) return false;
			temp = temp.next;
			list = list.next;
		}
		mid.print();
		rev.print();
			
		return true;
	}
}
