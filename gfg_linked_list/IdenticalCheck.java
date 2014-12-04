public class IdenticalCheck {

	public static void main(String args[]) {
		LinkedList list1 = new LinkedList(0);
		LinkedList list2 = new LinkedList(0);

		for(int i = 1; i < 5; i++){
			list1.addToTail(i);
			list2.addToTail(i);
		}
		boolean check = isIdentical(list1, list2);
		System.out.println("Result: " + check);
		check = checkRec(list1, list2);
		System.out.println("Result: " + check);
		
		list1.addToTail(6);
		check = isIdentical(list1, list2);
		System.out.println("Result: " + check);
		check = checkRec(list1, list2);
		System.out.println("Result: " + check);
	}

	public static boolean checkRec(LinkedList a, LinkedList b) {
		if(a == null && b == null) return true;
		if(a == null && b != null) return false;
		if(a != null && b == null) return false;
		if(a.data != b.data) return false;
		return checkRec(a.next, b.next);
	}

	public static boolean isIdentical(LinkedList a, LinkedList b) {
		while(true) {
			if(a == null && b == null) return true;
			if(a == null && b != null) return false;
			if(a != null && b == null) return false;
			if(a.data != b.data) return false;
			a = a.next;
			b = b.next;
		}
	}
}
