public class NodeTest{

	public static void main(String args[]){
		int d = 1;
		Node list = new Node(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		
		System.out.println(list.toString());

		list = list.deleteNode(list, 2);

		System.out.println(list.toString());		
	}
}
