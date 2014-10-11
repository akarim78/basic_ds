import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {

	TNode root;
	static final int IN_ORDER = 0;
	static final int PRE_ORDER = 1;
	static final int POST_ORDER = 2;

	public BinarySearchTree() {
		this.root = null;
	}

	public int getClosest(int m) {
		return m+minDiff(this.root, m);
	}

	private int minDiff(TNode node, int m){
		if(node == null) return Integer.MAX_VALUE;

		if(node.data < m)
			return smallDiff(node.data - m, minDiff(node.right, m));
		else
			return smallDiff(node.data - m, minDiff(node.left, m));
	}

	private int smallDiff(int a, int b) {
		if(Math.abs(a) > Math.abs(b)) return b;
		return a;
	} 

	public void printTreeLevel(int level) {
		if(level < 0) return;
		if(root == null) return;
		Queue<TNode> q = new LinkedList<TNode>();
		Queue<Integer> qLevel = new LinkedList<Integer>();
		q.add(root);
		qLevel.add(0);
		while(!q.isEmpty()) {
			TNode t = q.poll(); // dequeue
			int currentLevel = qLevel.poll();
			if(t == null) return;
			else if(currentLevel == level)
				System.out.print(t.data + " ");
			else{
				q.add(t.left);
				qLevel.add(currentLevel + 1);
				q.add(t.right);
				qLevel.add(currentLevel + 1);
			}

		}

			
	}

	public void printLevel(int levelToPrint) {
		if(levelToPrint < 0) return;
		if(this.root == null) {
			return;
		} else{
			printLevelRecursive(root, 0, levelToPrint);
		}
	}

	private void printLevelRecursive(TNode node, int level, int levelToPrint) {
		if(node == null) return;
		if(level == levelToPrint) System.out.print(node.data + " ");
		level ++;
		printLevelRecursive (node.left, level, levelToPrint);
		printLevelRecursive (node.right, level, levelToPrint);
	}	

	public boolean isBST() {
		if(this.root == null) {
			return true;
		}
		//return isValidBST(this.root);
		return ifBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean ifBST(TNode node, int small, int large) {
		if(node == null) return true;
		if(node.data > small && node.data < large) {
			return ifBST(node.left, small, node.data) && ifBST(node.right, node.data, large);

		} else {
			return false;
		}
	}

	private boolean isValidBST(TNode node) {
		if(node == null) return true;
		else if(node.left == null && node.right == null) return true;
		else if(node.left != null && node.left.data > node.data) return false;
		else if(node.right != null && node.right.data < node.data) return false; 		else return isValidBST(node.left) && isValidBST(node.right);
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
