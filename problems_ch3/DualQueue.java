// considering odd-> cat and even-> dog
public class Queue{
	Node first, last;
	Node catFirst, catLast;
	Node dogFirst, dogLast;
	
	public Queue(){
		first = null;
		last = null;
	}

	public void enqueue(int d){
		if(first == null){
			last = new Node(d);
			first = last;
		} else{
			last.next = new Node(d);
			last = last.next;
		}

		if(d%2 == 0){
			dog = last;
		}else{
			cat = last;
		}
	}

	public Node dequeueiAny(){
		if(first !=null){
			Node n = first;
			first = first.next;
			return n;
		}
		return null;
	}

	public Node dequeueCat()


}
