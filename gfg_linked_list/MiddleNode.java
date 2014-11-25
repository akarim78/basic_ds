public class MiddleNode {
	public static void main(String args[]) {
		LinkedList head = new LinkedList(0);
		LinkedList mid = head.getMiddleNode();
		head.print();
		mid.print();

		head.addToTail(1);
		mid = head.getMiddleNode();                                    
                head.print();
                mid.print();

		head.addToTail(2);
                mid = head.getMiddleNode();
                head.print();
                mid.print(); 

		head.addToTail(3);                                                        
                mid = head.getMiddleNode();
                head.print();
                mid.print();

		head.addToTail(4);
		head.addToTail(5);
		head.addToTail(6);
		head.addToTail(7);                                                        
                mid = head.getMiddleNode();
                head.print();
                mid.print();	

	}
}
