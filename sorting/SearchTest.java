public class SearchTest{

	public static void main(String args[]){
		int[] data = {1, 2, 3, 4, 5, 6, 7, 8};

		int p = Search.binarySearch(data, 2);
		int q = Search.binarySearchRecursive(data, 2, 0, data.length - 1);

		System.out.println("Pos: " + p + " " + q);

	}
}
