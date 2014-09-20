public class BinarySearchTree{
	public Node root;
	public static final int IN_ORDER = 0;
	public static final int PRE_ORDER = 1;
	public static final int POST_ORDER = 2;


	private Node parent;

	public BinarySearchTree(){
		this.root = null;
	}

	public void insert(int d){
		Node n = new Node(d);
		Node temp = root;
		if(temp == null){
			root = n;
		} else{
			traverseAndInsert(root, n);
		}

	}

	private void traverseAndInsert(Node current, Node nodeToAdd){
		//System.out.println("Current: " + current.data +" to add: " + nodeToAdd.data);
		if(nodeToAdd.data <= current.data){
			System.out.println("Left:: Current: " + current.data +" to add: " + nodeToAdd.data);
			if(current.left == null){
				nodeToAdd.parent = current;
				current.left = nodeToAdd;
			} else{
				traverseAndInsert(current.left, nodeToAdd);
			}
		} else {
			System.out.println("Right:: Current: " + current.data +" to add: " + nodeToAdd.data);
			if(current.right == null){
				nodeToAdd.parent = current;
				current.right = nodeToAdd;
			} else{
				traverseAndInsert(current.right, nodeToAdd);
			}
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
                        	postOrderTraversal(root.right);
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
