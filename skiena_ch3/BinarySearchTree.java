public class BinarySearchTree {

	TNode root;
	static final int IN_ORDER = 0;
	static final int PRE_ORDER = 1;
	static final int POST_ORDER = 2;

	public BinarySearchTree() {
		this.root = null;
	}

	public boolean search(int d) {
		if(root == null) {
			return false;
		} else {
			return searchNode(root, d);
		}

	}

	private boolean searchNode(TNode node, int d) {
		if(node == null) return false;
		if(node.data == d) return true;
		if(d < node.data) return searchNode(node.left, d);
		if(d > node.data) return searchNode(node.right, d);
		return false;
	}

	public void remove(int d) {
		if(root == null) return;
		TNode found = find(root, d);	
		if(found == null) {
			System.out.println("Not found. Couldn't remove");
		} else{
			System.out.println("Found: will remove now");
		}
	}

	private TNode find(TNode current, int d) {
		if(current == null) return null;
		if(current.data == d) return current;
                if(d < current.data) {
			if(current.left == null) return null;
			else return find(current.left, d);
		}
                if(d > current.data) {
			if(current.right == null) return null;
			else return find(current.right, d);
		}
		return null;
	}

	public void insert(int d) {
		TNode t = new TNode(d);
		if(this.root == null) {
			this.root = t;
		} else {
			traverseAndInsert(root, t);
		}
	}

	private void traverseAndInsert(TNode current, TNode nodeToAdd) {
		if(current == null || nodeToAdd == null) return;
		if(nodeToAdd.data < current.data) {
			System.out.println("Left: current: " + current.data + " add: " + nodeToAdd.data);
			if(current.left == null) {
				current.left = nodeToAdd;
				nodeToAdd.parent = current;
			} else {
				traverseAndInsert(current.left, nodeToAdd);
			}
		} else if(nodeToAdd.data > current.data) {
			System.out.println("Right: current: " + current.data + " add: " + nodeToAdd.data);
			if(current.right == null) {
				current.right = nodeToAdd;
				nodeToAdd.parent = current;
			} else{
				traverseAndInsert(current.right, nodeToAdd);
			}
		}

		
	}

	public void traverse(int type) {
		if(type == IN_ORDER) {
			if(this.root != null) traverseInOrder(root);
		} else if(type == PRE_ORDER) {
			if(this.root != null) traversePreOrder(root);
		} else if(type == POST_ORDER) {
			if(this.root !=null ) traversePostOrder(root);
		}

	}

	private void traverseInOrder(TNode node) {
		if(node == null) return;
		if(node.left != null) traverseInOrder(node.left);
		System.out.print(node.toString() + " ");
		if(node.right != null) traverseInOrder(node.right);
	}
	
	private void traversePreOrder(TNode node) {                                                      
                if(node == null) return;
		System.out.print(node.toString() + " ");
                if(node.left != null) traversePreOrder(node.left);                                      	        if(node.right != null) traversePreOrder(node.right);                                     
        }

	private void traversePostOrder(TNode node) { 
                if(node == null) return;
                if(node.left != null) traversePostOrder(node.left);                                           		if(node.right != null) traversePostOrder(node.right);
		System.out.print(node.toString() + " ");                                     
        }
}
