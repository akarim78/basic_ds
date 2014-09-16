public class StackQueueTest{

	public static void main(String args[]){
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		Node n1 = stack.pop();
		System.out.println("Pop: " + n1.data);

		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		Node n2 = queue.dequeue();
		System.out.println("Dequeue: " + n2.data);
	

	}
}
