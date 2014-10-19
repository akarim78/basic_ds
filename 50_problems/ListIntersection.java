public class ListIntersection {

	public static void main(String args[]) {
		LNode common = new LNode(5);
		common.next = new LNode(6);
		common.next.next = new LNode(7);

		LNode list1 = new LNode(1);
		list1.next = new LNode(2);
		list1.next.next = new LNode(3);
		list1.next.next.next = common;

		LNode list2 = new LNode(4);
		list2.next = new LNode(5);
		list2.next.next = common;

		list1.print();
		list2.print();
		LNode inter = intersection(list1, list2);
		inter.print();
		
	}

	public static LNode intersection(LNode a, LNode b) {
		int aLen = 0;
		int bLen = 0;
		LNode current = a;
		while(current != null) {
			aLen ++;
			current = current.next;
		}
		current = b;
		while(current != null) {
			bLen ++;
			current = current.next;
		}

		if(aLen > bLen) {
			for(int i = 0; i < aLen - bLen; i++)
				a = a.next;
		}

		if(bLen > aLen) {
			for(int i = 0; i< bLen - aLen; i++)
				b = b.next;
		}

		while(a != b && a != null && b != null) {
			a = a.next;
			b = b.next;
		}
		return a;
	}

}

class LNode {

	int data;
	LNode next;

	public LNode(int d) {
		this.data = d;
	}

	public void print() {
		LNode temp = this;
		while(temp != null){
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("NULL");
		System.out.println();
	}
}
