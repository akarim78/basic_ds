public class ReversePrint {
	public static void main(String args[]) {
		LinkedList l = new LinkedList(0);
		for(int i = 1; i< 10; i++){
			l.addToTail(i);
		}
		l.print();
		printReverse(l);
	}

	public static void printReverse(LinkedList list) {
		if(list == null) return;
		printReverse(list.next);
		System.out.print(list.data+" ");
	}
}
