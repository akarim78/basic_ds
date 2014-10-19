import java.util.Stack;

public class InPreNoRecursion {

	public static void main(String args[]) {
		// 2*3+4*5
		Tree t = new Tree(5);
		t.left = new Tree(3);
		t.right = new Tree(8);
		t.left.left = new Tree(1);
		t.left.right = new Tree(4);
		t.right.left = new Tree(7);
		t.right.right = new Tree(9);
		
		t.inOrder();
		System.out.println();
		t.inOrderNonRec();
		System.out.println();
		t.preOrder();
                System.out.println();
                t.preOrderNonRec();
                System.out.println();
	}
}

class Tree{
	Tree left;
	Tree right;
	int value;
	public Tree(int in) {
		this.value = in;
	}
	
	// recursive
	public void inOrder() {
		if(left != null)
			left.inOrder();
		System.out.print(value + " ");
		if(right != null)
			right.inOrder();
		
	}

	// non recursive
	public void inOrderNonRec(){
		Stack<Tree> stack = new Stack<Tree>();
		Tree current = this;

		while(current != null || !stack.isEmpty()) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			} else{
				current = stack.pop();
				System.out.print(current.value + " ");
				current = current.right;
			}
		}
	}
	// preorder rec
	public void preOrder() {
		System.out.print(value+ " ");
		if(left != null)
                        left.preOrder();
                if(right != null)
                        right.preOrder();

	}

	public void preOrderNonRec() {
		Stack<Tree> stack = new Stack<Tree>();
		Tree current = this;
		while(current != null || !stack.isEmpty()) {
                        if(current != null) {
				System.out.print(current.value + " ");
				stack.push(current.right);
				current = current.left;

                        } else{
				current = stack.pop();
                        }
 
                }

	}
}
