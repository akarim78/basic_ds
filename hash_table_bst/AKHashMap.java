
public class AKHashMap{
	
	private AKBinarySearchTree map;

	public AKHashMap(){
		map = new AKBinarySearchTree();
	}


	public void put(int key, Student node){
		map.insert(node);
	}

	public Student get(int key){
		return map.lookup(key);	
	}

	public Student remove(int key){
		return null;
	}

	public String toString(){
		return "";
	}

}

