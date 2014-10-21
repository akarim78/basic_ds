import java.io.PrintStream;

public class BinaryTreeTraversal
{
	public static void main(String[] paramArrayOfString)
  	{
    		BinaryTree tree = new BinaryTree(5);
    		tree.left = new BinaryTree(3);
    		tree.left.left = new BinaryTree(1);
    		tree.left.left.left = new BinaryTree(0);
   	 	tree.left.left.right = new BinaryTree(2);
    		tree.left.right = new BinaryTree(4);
    		tree.right = new BinaryTree(7);
    		tree.right.left = new BinaryTree(6);
    		tree.right.right = new BinaryTree(9);
    		tree.right.right.left = new BinaryTree(8);
    		tree.right.right.right = new BinaryTree(10);
		
		// root to leaves path print
    		tree.printRootToLeaves();

		// counting leaves
    		System.out.println("Number of leaves: " + tree.countLeaves());
		System.out.println();

		System.out.println("Depth: " + tree.maxDepth());
		// level order queue
		System.out.println("Level Order: Queue");
		tree.levelOrderQueue(tree);
		System.out.println();

		// level order traversal
		System.out.println("Level Order: Ite");
		tree.levelOrderTraversal(tree);
		System.out.println();

		// mirror of tree
		tree.mirror();

		// traversal
		System.out.print("In order rec: ");
		tree.inorderRecursive();
		System.out.println();

		System.out.print("In order ite:");
		tree.inorderIterative();
		System.out.println();
		
		int[] pre = {1, 2, 7, 6, 3, 5, 4};
		int[] in = {7, 2, 6, 1, 5, 3, 4};
		BinaryTree p = construct(pre, 0, pre.length-1, in, 0, in.length-1);
		p.inorderRecursive();
		System.out.println();
		
  	}

  	public static BinaryTree construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
    		if (preStart > preEnd) return null;
    		if (preStart == preEnd) return new BinaryTree(pre[preStart]);

    		int rootIndex = 0;
    		for (int i = inStart; i <= inEnd; i++) {
      			if (in[i] == pre[preStart]) {
        			rootIndex = i;
        			break;
      			}
    		}
    		int leftCount = rootIndex - inStart;
    		int rightCount = inEnd - rootIndex;
    		BinaryTree root = new BinaryTree(pre[preStart]);
    		root.left = construct(pre, preStart + 1, preStart + leftCount, in, inStart, rootIndex - 1);
    		root.right = construct(pre, preEnd - rightCount + 1, preEnd, in, rootIndex + 1, inEnd);

    		return root;
  	}
}
