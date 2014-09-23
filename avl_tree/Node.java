public class Node{
	int data;
	Node left;
	Node right;
	Node parent;	
	int height;

	public Node(int d){
		this.data = d;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.height = 0;
	}	

	public void setData(int d){
		this.data = d;
	}

	public int getData(){
		return this.data;
	}

	public void setLeft(Node l){
		this.left = l;
	}

	public void setRight(Node r){
		this.right = r;
	}

	public Node getLeft(){
		return this.left;
	}

	public Node getRight(){
		return this.right;
	}

	public void setParent(Node n){
		this.parent = n;
	}

	public Node getParent(){
		return this.parent;
	}

	public String toString(){
		return "Node: " + this.data;
	}

	public int getHeight(){
		return this.height;
	}

	public void setHeight(int h){
		this.height = h;
	}
}
