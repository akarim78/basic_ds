
public class Stack{

	Node top;

	public Stack(){
		top = null;
	}

	public Vertex pop(){
		if(top != null){
			Node n = new Node(top.data, top.v);
			top = top.next;
			return n.v;
		}
		return null;
	}

	public void push(Vertex v){
		Node t = new Node(v.data, v);
		t.next = top;
		top = t;
	}

	public Vertex peek(){
		return top.v;
	}

	public boolean isEmpty() {
		return top == null;
	}
}
