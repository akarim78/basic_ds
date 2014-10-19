public class MidList {
	public static void main(String args[]) {
		List list = new List(1);
		list.next = new List(2);
		list.next.next = new List(3);
		list.next.next.next = new List(4);
		list.next.next.next.next = new List(5);
		//list.next.next.next.next.next = new List(6);
		List mid = findMid(list);
		mid.print();

		findMidRec(list);
	}

	static int listLen = 0;
	static int revIndex = 0;
	public static void findMidRec(List l) {
		if(l != null) {
			listLen ++;
			findMidRec(l.next);
			revIndex ++;
		}
		if(revIndex * 2 == listLen || revIndex * 2 == listLen + 1){
			l.print();
		}

	}

	public static List findMid(List l) {
		List fast = l;
		List slow = l;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;

	}
}

class List{
	int data;
	List next;

	public List(int d) {
		this.data = d;
	}

	public void print() {
		List temp = this;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
		System.out.println();
	}

}
