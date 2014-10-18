public class ListInterweave {

	public static void main(String args[]) {
		LList initial = new LList(1);
		initial.next = new LList(2);
		initial.next.next = new LList(3);
		initial.next.next.next = new LList(4);
		initial.next.next.next.next = new LList(5);
		initial.print();		

		LList mid = findMid(initial);
		mid.print();
		
		LList revMid = reverse(mid.next);
		revMid.print();
		mid.next = null;		

		LList merged = merge(initial, revMid);
		merged.print();
	}

	// find midpoint of LL in linear time
	public static LList findMid(LList l) {
		LList fast = l; // 2 steps
		LList slow = l; // 1 steps

		while(fast != null && fast.next != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	// reverse 2nd part
	public static LList reverse(LList l) {
		if(l == null || l.next == null)
			return l;

		LList rev = reverse(l.next);
		l.next.next = l;
		l.next = null;
		return rev;
	}

	// merge
	public static LList merge(LList l1, LList l2) {
		LList merged = new LList(0);
		LList current = merged;
		int turn = 1;
		while(l1 != null  && l2 !=null) {
			if(turn == 1) {
				current.next = l1;
				l1 = l1.next;
				turn = 2;
			} else {
				current.next = l2;
				l2 = l2.next;
				turn = 1;
			}
			current = current.next;
		}
		if(l1!=null)
			current.next = l1;
		return merged.next;
	}
}

class LList {

	int value;
	LList next;

	public LList(int v) {
		this.value = v;
	}

	public void print() {
		LList tmp = this;

		while(tmp != null) {
			int v = tmp.value;
			System.out.print(v + " -> ");
			tmp = tmp.next;
		}
		System.out.print("NULL");
		System.out.println();
	}
}
