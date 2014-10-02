public class Node{

	Node next = null;
	Vertex v = null;
	int data;
	public Node(int d, Vertex v){
		this.data = d;
		this.v = v;
	}

	public void appendToTail(int d, Vertex v){
		Node  end = new Node(d, v);
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
