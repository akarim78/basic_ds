public class ReconstructBST{

	public static void main(String args[]) {
		Tree t = new Tree(5);
                t.left = new Tree(3);
                t.right = new Tree(8);
                t.left.left = new Tree(1);
                t.left.right = new Tree(4);
                t.right.left = new Tree(7);
                t.right.right = new Tree(9);
 
                t.inOrder();
                System.out.println();
                t.preOrder();
                System.out.println();

		int[] pre = {5, 3, 1, 4, 8, 7, 9};
		int[] in = {1, 3, 4, 5, 7, 8, 9};
		Tree p = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		p.inOrder();
		System.out.println();
	}

	public static Tree construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		if(preStart > preEnd) return null;
		if(preStart == preEnd) return new Tree(pre[preStart]);
		
		int rootIndexInOrder = 0;
		for(int i = inStart; i <= inEnd; i++) {
			if(in[i] == pre[preStart]) { // looking for root, left and right
				rootIndexInOrder = i;
				break;
			}
		}
		int countLeft = rootIndexInOrder - inStart;
		int countRight = inEnd - rootIndexInOrder;
		Tree root = new Tree(pre[preStart]);
		root.left = construct(pre, preStart + 1, preStart + countLeft, in, inStart, inStart + countLeft - 1);
		root.right = construct(pre, preStart + countLeft + 1, preEnd, in, inStart + countLeft + 1, inEnd);
		return root;

	}
}

class Tree {
	int value;
	Tree left;
	Tree right;

	public Tree(int d) {
		this.value = d;
	}

	// recursive
        public void inOrder() {
                if(left != null)
                        left.inOrder();
                System.out.print(value + " ");
                if(right != null)
                        right.inOrder();
 
        }
 
        // preorder rec
        public void preOrder() {
                System.out.print(value+ " ");
                if(left != null)
                        left.preOrder();
                if(right != null)
                        right.preOrder();
 
        }

	public String toString() {
		return "Node: " + value;
	}
}
