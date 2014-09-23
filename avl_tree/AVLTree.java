public class AVLTree{
	public Node root;
	public static final int IN_ORDER = 0;
	public static final int PRE_ORDER = 1;
	public static final int POST_ORDER = 2;

	public AVLTree(){
		this.root = null;
	}

	public void insert(int d){
		Node n = new Node(d);
		Node current = root;
		root = traverseAndInsert(current, n);
	}

	private int getHeight(Node n){
		if(n == null){
			return 0;
		}
		return n.height;
	}

	private Node traverseAndInsert(Node current, Node nodeToAdd){
		//System.out.println("Current: " + current.data +" to add: " + nodeToAdd.data);
		if(current == null){
			return nodeToAdd; 
		}

		if(nodeToAdd.data < current.data){
			current.left = traverseAndInsert(current.left, nodeToAdd);
			//nodeToAdd.parent = current;
		} else{
			current.right = traverseAndInsert(current.right, nodeToAdd);
			//nodeToAdd.parent = current;
		}
		current.height = max(getHeight(current.left), getHeight(current.right)) + 1;
		int balance = getHeight(current.left) - getHeight(current.right);

		// rotating
		// left-left
		if(balance > 1 && nodeToAdd.data < current.left.data){
			System.out.println("Case: Left-Left");
			return rotateRight(current);
		}
		// right-right
		if(balance < -1 && nodeToAdd.data > current.right.data){
			System.out.println("Case: Right-Right");
			return rotateLeft(current);
		}

		// left-right
		if(balance > 1 && nodeToAdd.data > current.left.data){
			System.out.println("Case: Left-Right");
			current.left = rotateLeft(current.left);
			return rotateRight(current);

		}
		// right-left
		if(balance < -1 && nodeToAdd.data < current.right.data){
			System.out.println("Case: Right-Left");
			current.right = rotateRight(current.right);
			return rotateLeft(current);
		}

		return current;
		
	}

	private Node rotateRight(Node current){
		Node y = current.left;
		Node temp = y.right;

		//current.parent.left = y;
		//y.parent = current.left;
		y.right = current;
		//current.parent = y;
		current.left = temp;
		//temp.parent = current;

		current.height = max(getHeight(current.left), getHeight(current.right)) + 1;
		y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

		return y;

	}

	private Node rotateLeft(Node current){
		Node y = current.right;
		Node temp = y.left;

		//current.parent.right = y;
		//y.parent = current.parent;
		y.left = current;
		//current.parent = y;
		current.right = temp;
		//temp.parent = current;
		//
		current.height = max(getHeight(current.left), getHeight(current.right)) + 1;
		y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
		
		return y;
	}

	private int max(int x, int y){
		if(x >= y){
			return x;
		} else{
			return y;
		}
	}

	public Node remove(int d){
		// CASE 1: Node has no children
		// CASE 2: Node has 1 child
		// CASE 3: Node has 2 children
		Node found = find(d);
		
		if(found != null){
			// delete
			if(found.left == null && found.right == null){
				deleteCase1(found);
			} else if(found.left != null && found.right != null){
				deleteCase3(found);
			} else if(found.left == null || found.right == null){
				deleteCase2(found);
			}
		}
		return found;
	}

	

	private void deleteCase1(Node found){
		Node parent = found.parent; // this will be null for root
                if(parent.left == found){
	                parent.left = null;
                } else if(parent.right == found){
 	               parent.right = null;
                }
	}

	private void deleteCase2(Node found){
		Node parent = found.parent;
                if(parent.left == found){
	                if(found.left != null){
	                        parent.left = found.left;
                        } else{
	                        parent.left = found.right;
                        }
		}else if(parent.right == found){
 	               if(found.left != null){
	                       parent.right = found.left;
                       } else{
                               parent.right = found.right;
                       }
                }
	}

	private void deleteCase3(Node found){
		Node parent = found.parent;
                Node minNode = minLeftTraversal(found.right);
		//if(found == root)
		//	System.out.println("Root------------------------------");
		// got the replacement node
		// need to delete the minNode
		if(minNode.right!=null){
			deleteCase2(minNode);
		}else{
			deleteCase1(minNode);
		}
		
		
		minNode.parent = parent;
                minNode.left = found.left;                                                                                                                                                 
                minNode.right = found.right;
		if(found.left != null)
			found.left.parent = minNode;
		if(found.right != null)
			found.right.parent = minNode;
		if(parent !=null){
			if(parent.left == found){
				parent.left = minNode;
			} else if(parent.right == found){
				parent.right = minNode;
			}
		}else{
			root = minNode;
		}
	}

	private Node minLeftTraversal(Node n){
		if(n.left == null) {
			return n;
		}

		return minLeftTraversal(n.left);
	}

	private Node find(int d){
		
		if(root != null){
			return findNode(root, d);	
		}
		return null;
	}

	public Node findNode(Node node, int d){

		if(node == null){
			return null;
		}
		if(node.data == d){
			return node;
		}else{
			Node returnNode = findNode(node.left, d);
			if(returnNode == null){
				returnNode = findNode(node.right, d);
			}

			return returnNode;
		}
	}

	// in-order, pre-order and post-order traversal
	public void traverse(int type){
		if(type == IN_ORDER){	
			if(root != null){
				inOrderTraversal(root);
			}
		} else if(type == PRE_ORDER){
			if(root != null){
                                preOrderTraversal(root);
                        }
		} else if(type == POST_ORDER){
			if(root != null){
                        	postOrderTraversal(root);
                        }
		}	
	}

	public void inOrderTraversal(Node node){
		if(node.left != null){
			inOrderTraversal(node.left);
		}

		System.out.println("Node: " + node.data);
		if(node.right != null){
			inOrderTraversal(node.right);
		}
	}

	public void preOrderTraversal(Node node){
		System.out.println("Node: " + node.data);
                if(node.left != null){
                        preOrderTraversal(node.left);
                }
                if(node.right != null){
                        preOrderTraversal(node.right);
                }
        }

	public void postOrderTraversal(Node node){
                if(node.left != null){
                        postOrderTraversal(node.left);
                }
                if(node.right != null){
                        postOrderTraversal(node.right);
                }
		System.out.println("Node: " + node.data);
        }

}
