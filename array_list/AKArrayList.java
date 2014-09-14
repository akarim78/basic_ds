public class AKArrayList{

	private String[] arrayList;
	private int capacity = 10;
	private int size = 0;
	public AKArrayList(int capacity){
		this.capacity = capacity;
		this.size = 0;
		arrayList = new String[this.capacity];
	}

	public AKArrayList(){
		arrayList = new String[this.capacity];
	}

	public void insert(int index, String s){
		
		if(index > size){
			System.out.println("Error: ");
		}else{
			if(this.capacity == this.size+1){
				this.capacity *= 2;
			}
		}
		String[] temp=new String[this.capacity];
		for(int i=0; i<index; i++){
			temp[i] = arrayList[i];
		}
		temp[index] = s;
		this.size++;
		for(int i=index+1; i < this.size; i++){
			temp[i] = arrayList[i-1];
		}
		this.arrayList = temp;

	}

	public String get(int index){
		return this.arrayList[index];
	}

	public void add(String s){
		if(this.capacity == this.size + 1){
			this.capacity *= 2;
			String[] temp = new String[capacity];
			for(int i=0; i<this.size; i++){
				temp[i] = arrayList[i];
			}
			arrayList = temp;
		}
		arrayList[this.size] = s;
		this.size ++;
	}

	public int getSize(){
		return this.size;
	}

	public String toString(){
		String str = "Capacity: " + capacity + " Size: " + size; 
		for(int i=0; i<this.size; i++){
			str+= " "+this.arrayList[i];
		}
		return str;
	}
}
