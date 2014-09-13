public class AKHashTableTest{
	public static void main(String args[]){
		AKHashMap stdMap = new AKHashMap(5);
		Student[] students = new Student[5];
		students[0] = new Student(1, "A");
		students[1] = new Student(2, "B");
		students[2] = new Student(3, "C");
		students[3] = new Student(6, "D");
		students[4] = new Student(7, "E");

		for(Student std: students){
			stdMap.put(std.getId(), std);
		}

		Student s = stdMap.get(7);
		System.out.println("Id: "+s.getId()+" Name: "+s.getName());
	}
}
