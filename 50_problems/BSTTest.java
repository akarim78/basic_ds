public class BSTTest {

	public static void main(String args[]) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(6);
		tree.insert(3);
		tree.insert(9);
		tree.insert(7);
		tree.insert(4);
		tree.insert(1);
		tree.insert(10);
		//tree.root.left.data = 15;
		tree.traverse(BinarySearchTree.IN_ORDER);
		System.out.println();
		tree.traverse(BinarySearchTree.PRE_ORDER);
		System.out.println();
		tree.traverse(BinarySearchTree.POST_ORDER);
		System.out.println();
		System.out.println("5: " + tree.search(5) + " 10: " + tree.search(10));

		System.out.println("BST Test: " + tree.isBST());
	}
}
