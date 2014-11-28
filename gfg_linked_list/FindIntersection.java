public class FindIntersection {

	public static LinkedList getIntersection(LinkedList l1, LinkedList l2){
		int len1 = l1.getLength();
		int len2 = l2.getLength();
		if(len1 > len2) {
			int diff = len1 - len2;
			int count = 0;
			while(count < diff) {
				l1 = l1.next;
				count++;
			}
		} else {
			int diff = len2 - len1;
			int count = 0;
			while(count < diff) {
				l2 = l2.next;
				count++;
			}
		}

		while(l1 != null && l2 != null) { 
			if(l1 == l2) return l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		return null;
	}

	public static void main(String args[]) {
		LinkedList l1 = new LinkedList(0);
		LinkedList l2 = new LinkedList(1);
		LinkedList l3 = new LinkedList(2);
		LinkedList l4 = new LinkedList(3);
		LinkedList l5 = new LinkedList(4);
		LinkedList l6 = new LinkedList(5);
		LinkedList l7 = new LinkedList(6);
		LinkedList l8 = new LinkedList(7);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		l6.next = l7;
		l7.next = l8;
		l8.next = l2;

		l1.print();
		l6.print();
		LinkedList x = getIntersection(l1, l6);
		
		if(x != null) x.print();
		else System.out.println("No intersection...");

	}
}
