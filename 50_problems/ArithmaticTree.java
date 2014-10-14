import java.util.Stack;
public class ArithmaticTree {

	// defining stack
	static Stack<Integer> stack = new Stack<Integer>();

	// supporting methods
	// if a string is number or operand
	public static boolean isOperator(String in){
		return in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/");
	}

	public static int compute(int a, int b, char op){
		
		switch(op){
			case '+': return a+b; 
			case '-': return a-b;
			case '*': return a*b;
			case '/': return a/b;
		}
		return -1;
	}

	public static void compute(Tree tree) {
		if(tree != null){
			compute(tree.left);
			compute(tree.right);
			//process current
			if(!isOperator(tree.value)) {// number
				stack.push(Integer.parseInt(tree.value));
			} else{
				int a = stack.pop();
				int b = stack.pop();
				int res = compute(a, b, tree.value.charAt(0));
				stack.push(res);
			}
		}

	}

	public static void main(String args[]) {
		// 2*3+4*5
		Tree t = new Tree("+");
		t.left = new Tree("*");
		t.right = new Tree("*");
		t.left.left = new Tree("2");
		t.left.right = new Tree("3");
		t.right.left = new Tree("4");
		t.right.right = new Tree("5");

		compute(t);
		System.out.println("Result is: " + stack.pop());

	}
}

class Tree{
	Tree left;
	Tree right;
	String value;
	public Tree(String in) {
		this.value = in;
	}
}
