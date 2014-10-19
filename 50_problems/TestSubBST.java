public class TestSubBST{

	public static void main(String args[]) {
		Tree t = new Tree(5);
                t.left = new Tree(3);
                t.right = new Tree(8);
                t.left.left = new Tree(1);
                t.left.right = new Tree(4);
                t.right.left = new Tree(7);
                t.right.right = new Tree(9);
 
                t.inOrder();
                System.out.println();
                t.preOrder();
                System.out.println();

		System.out.println("Ref Comp: " + isSubTreeRef(t, t.left));

		Tree t2 = new Tree(3);
		t2.left = new Tree(1);
		t2.right = new Tree(4);

		System.out.println("Value Comp: " + isSubTreeValue(t, t2));
		System.out.println("Ref Comp: " + isSubTreeRef(t, t2));
	}

	public static boolean isSubTreeValue(Tree t1, Tree t2) {
		if(t2 == null) return true;
		if(t1 == null) return false;
		if(t1.value == t2.value) {
			// check both left and right
			if(isSubTreeValue(t1.left, t2.left) && isSubTreeValue(t1.right, t2.right)) {
				return true;	
			}	
		} 
		// go for t1's left and right
		
		return isSubTreeValue(t1.left, t2) || isSubTreeValue(t1.right, t2);
	}	

	// finding based on references
	public static boolean isSubTreeRef(Tree t1, Tree t2) {
		if(t2 == null) return true;
		if(t1 == null) return false;
		return (t1 == t2) || isSubTreeRef(t1.left , t2) || isSubTreeRef(t1.right, t2);
	}

}

class Tree {
	int value;
	Tree left;
	Tree right;

	public Tree(int d) {
		this.value = d;
	}

	// recursive
        public void inOrder() {
                if(left != null)
                        left.inOrder();
                System.out.print(value + " ");
                if(right != null)
                        right.inOrder();
 
        }
 
        // preorder rec
        public void preOrder() {
                System.out.print(value+ " ");
                if(left != null)
                        left.preOrder();
                if(right != null)
                        right.preOrder();
 
        }

	public String toString() {
		return "Node: " + value;
	}
}
