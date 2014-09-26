public class Node{

	Node next = null;
	String data;
	public Node(String d){
		this.data = d;
	}

	public void appendToTail(String d){
		Node  end = new Node(d);
		Node n = this;
		while(n.next != null){
			//n = n.next;
			//System.out.println("Number: " + n.data);
			n = n.next;
		}

		n.next = end;
	}

	public Node deleteNode(Node head, String d){
		Node temp = head;
		if(temp.data.equals(d)){
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
