public class TNode {

	TNode parent;
	int data;
	TNode left;
	TNode right;

	public TNode(int d) {
		this.data = d;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	public String toString() {
		return "Node: " + this.data;
	}
}
