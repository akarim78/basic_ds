public class PrintTreeOutside {

	public static void main(String args[]) {
		Tree t = new Tree(5);
		t.left = new Tree(3);
		t.left.left = new Tree(1);
		t.left.right = new Tree(4);
		t.right = new Tree(8);
		t.right.left = new Tree(6);
		t.right.right = new Tree(9);

		t.preorderLeft();
		t.inorderLeaf();
		t.postorderRight();
	}


}

class Tree {
	int data;
	Tree left;
	Tree right;
	public Tree(int d) {
		this.data = d;
	}

	public void preorderLeft() {
		System.out.print(data + " > ");
		if(left != null && left.left !=null && left.right != null) left.preorderLeft();
	}

	public void inorderLeaf() {
		if(left != null) left.inorderLeaf();
		if(left == null && right == null) System.out.print(data + " > ");
		if(right != null) right.inorderLeaf();
	}

	public void postorderRight() {
		if(right != null && right.left!=null && right.right != null) right.postorderRight();
		System.out.print(data + " > ");
	}


	public String toString() {
		String s = "";
		s +="Node: " + this.data;
		if(left != null) s+= " Left: " + left.data;
		if(right != null) s+= " Right: " + right.data;
		return s;
	}
}
