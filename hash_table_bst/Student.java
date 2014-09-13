public class Student{
	int sId;
	String name;
	Student left = null;
	Student right = null;

	public Student(int sId, String name){
		this.sId = sId;
		this.name = name;
		this.left = null;
		this.right = null;
	}

	public Student setLeft(Student std){
		this.left = std;
		return this.left;
	}

	public Student setRight(Student std){
		this.right = std;
		return this.right;
	}

	public Student getLeft(){
		return this.left;
	}

	public Student getRight(){
		return this.right;
	}

	public int getId(){
		return this.sId;
	}

	public String getName(){
		return this.name;
	}
}
