public class Problem2{

	public static void main(String args[]){
		Stack stack = new Stack();
                stack.push(4);
                stack.push(2);
                stack.push(3);
		stack.push(5);

                Node n1 = stack.pop();

                System.out.println("Pop: " + n1.data + " Min: " + stack.min());			
	}
}
