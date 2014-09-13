public class Student{
	int sId;
	String name;
	Student next = null;

	public Student(int sId, String name){
		this.sId = sId;
		this.name = name;
		this.next = null;
	}

	public Student setNext(Student std){
		this.next = std;
		return this.next;
	}

	public Student getNext(){
		return this.next;
	}

	public int getId(){
		return this.sId;
	}

	public String getName(){
		return this.name;
	}
}
