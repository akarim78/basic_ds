public class BSTTest{

	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(7);
		bst.insert(12);
		bst.insert(18);
		bst.insert(1);
		bst.insert(4);		

		System.out.println("In Order: ");
		bst.traverse(BinarySearchTree.IN_ORDER);
		System.out.println("Pre Order: ");
		bst.traverse(BinarySearchTree.PRE_ORDER);
		System.out.println("Post Order: ");
		bst.traverse(BinarySearchTree.POST_ORDER);

		bst.remove(1);
	 	System.out.println("In Order: ");
                bst.traverse(BinarySearchTree.IN_ORDER);

		bst.remove(3);
		System.out.println("In Order: ");
                bst.traverse(BinarySearchTree.IN_ORDER);

		bst.remove(15);
	 	System.out.println("In Order: ");
                bst.traverse(BinarySearchTree.IN_ORDER);

		bst.remove(10);
	 	System.out.println("In Order: ");
                bst.traverse(BinarySearchTree.IN_ORDER);

	}
}
