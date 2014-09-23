public class AVLTreeTest{

	public static void main(String args[]){
		AVLTree bst = new AVLTree();
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(6);
		bst.insert(7);
		bst.insert(8);
		bst.insert(9);		

		System.out.println("In Order: ");
		bst.traverse(AVLTree.IN_ORDER);
		System.out.println("Pre Order: ");
		bst.traverse(AVLTree.PRE_ORDER);
		System.out.println("Post Order: ");
		bst.traverse(AVLTree.POST_ORDER);

		/*bst.remove(1);
	 	System.out.println("In Order: ");
                bst.traverse(AVLTree.IN_ORDER);

		bst.remove(3);
		System.out.println("In Order: ");
                bst.traverse(AVLTree.IN_ORDER);

		bst.remove(15);
	 	System.out.println("In Order: ");
                bst.traverse(AVLTree.IN_ORDER);

		bst.remove(10);
	 	System.out.println("In Order: ");
                bst.traverse(AVLTree.IN_ORDER);*/

	}
}
