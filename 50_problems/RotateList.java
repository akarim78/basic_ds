public class RotateList {

	public static void main(String args[]) {
		List list = new List(1);
		list.next = new List(2);
		list.next.next = new List(3);
		list.next.next.next = new List(4);
		list.next.next.next.next = new List(5);
		list.print();

		List rotated = rotate(list, 5);
		rotated.print();
	}

	public static List rotate(List l, int n) {
		List node = l;
		for(int i = 1; i < n; i++) {
			node = node.next;
		}

		List newHead = node.next;
		List temp = newHead;
		node.next = null;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = l;

		return newHead;
	}
}

class List {
	
	int data;
	List next;

	public List(int d) {
		this.data = d;
	}

	public void print() {
		List temp = this;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
		System.out.println();
		
	}
}
