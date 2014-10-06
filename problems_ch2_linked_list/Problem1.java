public class Problem1{

	public static void main(String args[]){
	 	Node list = new Node(1);
                list.appendToTail(2);
                list.appendToTail(3);
                list.appendToTail(2);
                list.appendToTail(1);
                list.appendToTail(1);
                list.appendToTail(4);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(2);
                System.out.println(list.toString());

                Node s = list.removeDuplicates(list);

                System.out.println(list.toString());	
	}
}
