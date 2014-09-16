
public class Stack{

	Node top;

	public Stack(){
		top = null;
	}

	public Node pop(){
		if(top != null){
			Node n = new Node(top.data);
			top = top.next;
			return n;
		}
		return null;
	}

	public void push(int d){
		Node t = new Node(d);
		t.next = top;
		top = t;
	}

	public int peek(){
		return top.data;
	}
}
