import java.util.Stack;

public class StackQueue{

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	public static void main(String args[]) {
		StackQueue sq = new StackQueue();
		sq.Enqueue(1);
		sq.Enqueue(2);
		sq.Enqueue(3);
		System.out.println(sq.Dequeue());
		sq.Enqueue(4);
		System.out.println(sq.Dequeue());  
		sq.Enqueue(5);
		sq.Enqueue(6);
		System.out.println(sq.Dequeue());  
		System.out.println(sq.Dequeue());  
		System.out.println(sq.Dequeue());  
		System.out.println(sq.Dequeue());  
	}
	
	public void Enqueue(int k) {
		s1.push(k);
	}

	public int Dequeue() {
		if(s2.isEmpty() && s1.isEmpty())
			return -1;
		else if(s2.isEmpty()) {
			while(!s1.isEmpty())
				s2.push(s1.pop());
			
		}
		return s2.pop();
	} 
	
}
