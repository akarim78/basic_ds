import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree
{
	int data;
  	BinaryTree left;
  	BinaryTree right;

  	public BinaryTree(int data)
  	{
    		this.data = data;
  	}

  	public int countLeaves() {
    		if ((this.left == null) && (this.right == null)) return 1;
    		int leftCount = 0;
    		int rightCount = 0;
    		if (this.left != null) leftCount = this.left.countLeaves();
    		if (this.right != null) rightCount = this.right.countLeaves();
    		return leftCount + rightCount;
  	}

  	public void printRootToLeaves() {
    		int[] path = new int[100];
    		int pathLen = 0;
    		rootToLeaf(this, path, pathLen);
  	}

  	private void rootToLeaf(BinaryTree node, int[] path, int pathLen)
 	{
    		if (node == null) return;
   	 	if (node != null) {
      			path[pathLen] = node.data;
      			pathLen++;
    		}

    		if ((node.left == null) && (node.right == null)) {
      			printPath(path, pathLen);
      			System.out.println();
     		 	return;
   		}
    		
		if (node.left != null)
      			rootToLeaf(node.left, path, pathLen);
    		if (node.right != null)
      			rootToLeaf(node.right, path, pathLen);
  	}

  	private void printPath(int[] path, int pathLen)
  	{
    		for (int i = 0; i < pathLen; i++)
      			System.out.print(path[i] + " ");
  	}

  	public void levelOrderQueue(BinaryTree node)
  	{
    		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
    		BinaryTree current = node;

    		while ((!queue.isEmpty()) || (current != null)) {
      			if (current != null) {
        			System.out.print(current.data + " ");
        			queue.add(current.left);
        			queue.add(current.right);
      			}
      			current = queue.poll();
    		}
  	}

	public void levelOrderSpiral(BinaryTree node) {
		if(node == null) return;
		int height = maxDepth();
		boolean ltr = false;
		for(int i = 1; i<=height; i++) {
			printGivenLevelSpiral(node, i, ltr);
			if(ltr) ltr = false;
			else ltr = true; 
		}
	
	}

	public void printGivenLevelSpiral(BinaryTree node, int level, boolean ltr) {
		if(node == null || level == 0) return;
		if(level == 1) System.out.print(node.data + " ");
		else {
			if(ltr) {
				if(node.left != null) printGivenLevelSpiral(node.left, level-1, ltr);
				if(node.right != null) printGivenLevelSpiral(node.right, level-1,ltr);
			} else {
				if(node.right!=null) printGivenLevelSpiral(node.right, level -1, ltr);
				if(node.left != null) printGivenLevelSpiral(node.left, level-1, ltr);
			}
		}

	}

  	public void levelOrderTraversal(BinaryTree node)
  	{
    		if (node == null) return;
    		int height = maxDepth();
    		for (int i = 1; i <= height; i++)
      			printGivenLevel(node, i);
  	}

  	public void printGivenLevel(BinaryTree node, int level) {
    		if ((node == null) || (level == 0)) return;
    		if (level == 1) { 
			System.out.print(node.data + " ");
    		} else {
      			if (node.left != null) printGivenLevel(node.left, level - 1);
      			if (node.right != null) printGivenLevel(node.right, level - 1);
    		}
  	}

  	private int max(int a, int b)
  	{
    		if (a > b) return a;
    		return b;
  	}

  	public int maxDepth() {
    		if ((this.left == null) && (this.right == null)) return 1;
    		int lDepth = 0;
    		int rDepth = 0;
   		if (this.left != null) lDepth = this.left.maxDepth();
    		if (this.right != null) rDepth = this.right.maxDepth();
    	
		return max(lDepth, rDepth) + 1;
  	}

  	public void mirror() {
    		if (this.left != null) this.left.mirror();
    		if (this.right != null) this.right.mirror();
   		BinaryTree temp = this.left;
    		this.left = this.right;
    		this.right = temp;
  	}

  	public void inorderRecursive() {
    		if (this.left != null) this.left.inorderRecursive();
    			System.out.print(this.data + " ");
    		if (this.right != null) this.right.inorderRecursive(); 
  	}

 	public void inorderIterative()
  	{
    		Stack<BinaryTree> stack = new Stack<BinaryTree>();
    		BinaryTree current = this;
    		while ((!stack.isEmpty()) || (current != null)){
      			if (current != null) {
        			stack.push(current);
        			current = current.left;
      			} else {
        			current = (BinaryTree)stack.pop();
        			System.out.print(current.data + " ");
        			current = current.right;
      			}
		}
  	}

  	public void preorderRecursive()
  	{
    		System.out.print(this.data + " ");
    		if (this.left != null) this.left.preorderRecursive();
    		if (this.right != null) this.right.preorderRecursive(); 
  	}

  	public void preorderIterative()
  	{
    		Stack<BinaryTree> stack = new Stack<BinaryTree>();
    		BinaryTree current = this;
    		while ((!stack.isEmpty()) || (current != null)) {
      			if (current != null) {
        			System.out.print(current.data + " ");
        			if (current.right != null) stack.push(current.right);
        			current = current.left;
      			} else {
        			current = stack.pop();
      			}
		}
  	}

  	public void postorderRecursive()
  	{
    		if (this.left != null) this.left.postorderRecursive();
    		if (this.right != null) this.right.postorderRecursive();
    		System.out.print(this.data + " ");
  	}

  	public void postorderIterative() {
    		Stack<BinaryTree> stack = new Stack<BinaryTree>();
   	 	BinaryTree current = this;
    		BinaryTree lastVisited = null;

    		while ((!stack.isEmpty()) || (current != null)) {
			if (current != null) {
        			stack.push(current);
        			current = current.left;
      			} else {
        			BinaryTree top = stack.peek();
        			if ((top.right != null) && (lastVisited != top.right)) {
          				current = current.right;
        			} else {
          				System.out.print(top.data + " ");
          				lastVisited = stack.pop();
      			 	}
     	 		}
  		}
	}

}
