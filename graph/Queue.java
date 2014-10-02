public class Queue{
	Node first, last;

	public Queue(){
		first = null;
		last = null;
	}

	public void enqueue(Vertex v){
		if(first == null){
			last = new Node(v.data, v);
			first = last;
		} else{
			last.next = new Node(v.data, v);
			last = last.next;
		}
	}

	public Vertex dequeue(){
		if(first !=null){
			Node n = first;
			first = first.next;
			return n.v;
		}
		return null;
	}

	public boolean isEmpty(){
		return (first == null);
	}

	public Vertex peek(){
		return first.v;
	}

}
