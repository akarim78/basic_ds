/*
 * Removing midlle element
 */


public class Problem3{

	public static void main(String args[]){
		Node list = new Node(1);
                list.appendToTail(2);
                list.appendToTail(3);
                list.appendToTail(4);
                list.appendToTail(5);
                list.appendToTail(6);
                list.appendToTail(7);
		list.appendToTail(8);
                System.out.println(list.toString());

                Node s = list.removeMidNode(list);
                System.out.println(list.toString());
	}
}
