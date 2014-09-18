public class MyQueue{
	
	Stack stack1;
	Stack stack2;

	public MyQueue(){
		stack1 = new Stack();
		stack2 = new Stack();
	}

	public void enqueue(int d){
		stack1.push(d);
	}

	public Node dequeue(){
		while(stack1.top !=null ){
			stack2.push(stack1.pop().data);
		}
		Node n = stack2.pop();
		while(stack2.top!=null){
			stack1.push(stack2.pop().data);
		}

		return n;
	}

}
