public class Queue{
	Node first, last;

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
	}

	public Node dequeue(){
		if(first !=null){
			Node n = first;
			first = first.next;
			return n;
		}
		return null;
	}


}
