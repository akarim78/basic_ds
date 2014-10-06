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

	public Node removeDuplicates(Node head){
		Node temp1 = head;
		Node temp2 = head;
		while(temp1!=null){
			while(temp2.next!=null){
				if(temp2.next.data == temp1.data){
					temp2.next = temp2.next.next;
									
				}else{
					temp2 = temp2.next;
				}
				//temp2 = temp2.next;

			}
			temp1 = temp1.next;
			temp2 = temp1;
		}
		return head;
	}

	public Node removeMidNode(Node head){
		// need to handle even and odd number of elements
		// what if n=1,2,3?
		Node temp1 = head;
		Node temp2 = head;
		//Node temp3 = head;
		while(temp2.next.next!=null){
			//temp3 = temp1;
			if(temp2.next!=null){
				temp1 = temp1.next;
			}
			temp2 = temp2.next.next;
		}

		temp1.next = temp1.next.next;

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
