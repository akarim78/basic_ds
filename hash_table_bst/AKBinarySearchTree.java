public class AKBinarySearchTree{
	private Student root;
	private int size;

	public AKBinarySearchTree(){
		this.root = null;
		this.size = 0;
	}

	public AKBinarySearchTree(Student s){
		this.root = s;
		this.size = 1;
	}

	public void insert(Student s){
		if(root == null){
			this.root = s;
		}else {
			Student temp = this.root;
			do{
				
				if(s.getId() <= temp.getId()){
					if(temp.getLeft()==null){
						temp.setLeft(s);
						break;
					}else{
						temp = temp.getLeft();
					}
				}else{
					if(temp.getRight()==null){
						temp.setRight(s);
						break;
					}else{
						temp = temp.getRight();
					}
				}
			}while(temp!=null);
		}
		this.size++;
		System.out.println("Size: "+size);
	}	

	public Student lookup(int key){
		Student temp = root;
		do{
			if(temp.getId() == key){
				return temp;
			}else if(key <= temp.getId()){
				temp = temp.getLeft();
			}else{
				temp = temp.getRight();
			}
		}while(temp != null);
		return null;
	}

	public void remove(int key){
		Student temp = root;
		if(temp!=null){
                	do{
                        	if(temp.getLeft().getId() == key){
                                	temp.setLeft(temp.getLeft().getLeft());
					//temp.setRight(temp.getLeft().getRight());
					this.size--;

                        	} else if(temp.getRight().getId()==key){
					temp.setLeft(temp);
				}
				else if(key <= temp.getId()){
                                	temp = temp.getLeft();

                        	}else{
                                	temp = temp.getRight();
                        	}

	                }while(temp != null);
		}
	}
}
