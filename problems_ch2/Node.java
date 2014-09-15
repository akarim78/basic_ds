public class Node{

	Node next = null;
	int data;
	public Node(int d){
		this.data = d;
	}

	public void appendToTail(int d){
		Node  end = new Node(d);
		Node n = this;
		while(n.next != null){
			//n = n.next;
			//System.out.println("Number: " + n.data);
			n = n.next;
		}

		n.next = end;
	}

	public Node deleteNode(Node head, int d){
		Node temp = head;
		if(temp.data == d){
			return head.next; // head is moved
		}

		while(temp.next != null){
			if(temp.next.data == d){
				temp.next = temp.next.next;
				return head; // head is not changed
			}
			temp = temp.next;
		}

		return head;
	}

	public Node deleteKthFromLast(Node head, int k){
		Node temp1 = head;
		Node temp2 = head;

		for(int i=0; i< k; i++){
			if(temp2.next == null){
				return null; // less than k elements in linked list
			}
			temp2 = temp2.next;
		}

		while(temp2.next!=null){
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		Node ret = temp1.next;
		temp1.next = temp1.next.next;

		return ret;

	}

	public String toString(){
		Node n = this;
		String str = "";
		while(n!=null){
			str += n.data+" ";
			n = n.next;
		}

		return str;
	}
	
}
