public class AKLinkedList{
	private Student head;
	private Student tail;
	private int size;

	public AKLinkedList(){
		this.size = 0;
		head = null;
		tail = null;
	}

	public void add(Student std){
		if(head == null && tail==null){
			// emplty list
			head = std;
			tail = std;
		} else{
			if(head == tail){
				head.setNext(std);
				tail = head.getNext();
			}else {
				tail.setNext(std);
				tail = tail.getNext();
			}
		}

		// System.out.println(head.getName()+"---"+tail.getName());
		this.size++;
	}

	public Student getStudent(int sId){
		Student temp = this.head;
		do{
			// System.out.println(temp.getName());
			if(sId == temp.getId()){
				return temp;
			}

			temp = temp.getNext();
		}while(temp!=null);
		return null;
	}

}
