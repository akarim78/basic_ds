public class Problem2{

	public static void main(String args[]){

                Node list = new Node(1);
                list.appendToTail(2);
                list.appendToTail(3);
                list.appendToTail(4);

                System.out.println(list.toString());
                list = list.deleteNode(list, 2);

                System.out.println(list.toString());
		list.appendToTail(5);
                list.appendToTail(6);
                list.appendToTail(7);

		System.out.println(list.toString());
		Node s = list.deleteKthFromLast(list, 3);
		System.out.println(list.toString());
		
	}
}
