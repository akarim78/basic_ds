
public class AKHashMap{
	
	private int capacity;
	private int nElements;
	private AKLinkedList[] map;

	public AKHashMap(){
		this.capacity = 10;
		this.nElements = 0;
		map = new AKLinkedList[this.capacity];
	}

	public AKHashMap(int capacity){
		this.capacity = capacity;
		this.nElements = 0;
		map = new AKLinkedList[capacity];
	}

	private int hash(int key){
		return (key % capacity);
	}

	public void put(int key, Student node){
		int index = hash(key);
		if(map[index] == null){
			map[index] = new AKLinkedList();
		}
		map[index].add(node);
		this.nElements++;
	}

	public Student get(int key){
		int index = hash(key);
		if(map[index] == null){
			return null;
		}else{
			return map[index].getStudent(key);
		}
	
	}

	public Student remove(int key){
		return null;
	}

	public String toString(){
		return "Capacity = "+this.capacity+" Elements: "+this.nElements;
	}

}

