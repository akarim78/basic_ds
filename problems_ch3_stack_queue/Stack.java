
public class Stack{

	Node top;
	Node min;

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

		if(min!=null){
			if(t.data < min.data){
				min = t;
			}
		}else{
			min = t;
		}
	}

	public int peek(){
		return top.data;
	}

	public boolean isEmpty(){
		return top == null;
	}

	public int min(){
		return min.data;
	}
}
