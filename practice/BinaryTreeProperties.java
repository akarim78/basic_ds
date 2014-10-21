public class BinaryTreeProperties
{
	public static void main(String[] paramArrayOfString)
  	{
    		BinaryTree tree = new BinaryTree(13);
    		tree.left = new BinaryTree(8);
    		tree.left.left = new BinaryTree(3);
		tree.left.left.right = new BinaryTree(9);
    		tree.left.right = new BinaryTree(5);
    		tree.right = new BinaryTree(5);
    		tree.right.left = new BinaryTree(2);
		tree.right.right = new BinaryTree(3);		
		System.out.print("In order ite:");
		tree.inorderIterative();
		System.out.println();
		System.out.println("Children sum property: " + isChildrenSum(tree));

		BinaryTree deepestRight = tree.getDeepestNodeIte(tree);
		System.out.println("Deepest: " + deepestRight.data );
				
  	}

	public static boolean isChildrenSum(BinaryTree node) {
		int leftData = 0;
		int rightData = 0;
		if(node==null || (node.left == null && node.right == null)) return true;
		if(node.left != null) leftData = node.left.data;
		if(node.right != null) rightData = node.right.data;
		
		return (node.data == (leftData+rightData)) && isChildrenSum(node.left) && isChildrenSum(node.right);
	}

	

}
