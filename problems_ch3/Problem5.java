/*
 * Implementing MyQueue using two Stacks
 *
 * MyQueue.java
 * Stack,java
 */

public class Problem5{

	public static void main(String args[]){
		MyQueue queue = new MyQueue();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		Node n = queue.dequeue();
		System.out.println("dequeue: " + n.data);
		n = queue.dequeue(); 
                System.out.println("dequeue: " + n.data);
		n = queue.dequeue(); 
                System.out.println("dequeue: " + n.data);

	}
}
