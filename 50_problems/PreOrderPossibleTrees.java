
import java.util.List;
import java.util.ArrayList;

public class PreOrderPossibleTrees {

	public static void main(String args[]) {
		// 2*3+4*5
		Tree t = new Tree(5);
		t.left = new Tree(3);
		t.right = new Tree(8);
		t.left.left = new Tree(1);
		t.left.right = new Tree(4);
		t.right.left = new Tree(7);
		t.right.right = new Tree(9);
		
		t.printInOrder();
		System.out.println();
		t.printPreOrder();
		System.out.println();
	
		int[] test = {1, 2, 3};
		List<Tree> result = getAllTrees(test, 0, test.length - 1);
		for(Tree tree: result) {
			tree.printInOrder();
		}
	}

	public static List<Tree> getAllTrees(int[] preorder, int start, int end) {
		List<Tree> returnTrees = new ArrayList<Tree>();
		if(start > end || start < 0 || end >= preorder.length) {
			returnTrees.add(null);
			return returnTrees;
		} 

		if(start == end) { // one element
			returnTrees.add(new Tree(preorder[start]));
			return returnTrees;
		}

		for(int i =-1; i < end-start; i++) {
			List<Tree> leftChildren = getAllTrees(preorder, start + 1, start + 1 + i);
			List<Tree> rightChildren = getAllTrees(preorder, start + 1 + i + 1, end);
			for(Tree eachLeft: leftChildren) {
				for(Tree eachRight: rightChildren) {
					Tree tempRoot = new Tree(preorder[start]);
					tempRoot.left = eachLeft;
					tempRoot.right = eachRight;
					returnTrees.add(tempRoot);
				}
			}
		}
		return returnTrees;
	}
}

class Tree{
	Tree left;
	Tree right;
	int value;
	public Tree(int in) {
		this.value = in;
	}
	
	public void printInOrder() {
		inOrder(this);
		System.out.println();
	}

	public void printPreOrder() {
		preOrder(this);
		System.out.println();
	}

	// recursive
	private void inOrder(Tree root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.value + " ");
		inOrder(root.right);		
	}

	// preorder rec
	private void preOrder(Tree root) {
		if(root == null) return;
		System.out.print(root.value+ " ");
		preOrder(root.left);
                preOrder(root.right);
	}

}
