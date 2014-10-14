public class Search2DSortedArray{

	public static void main(String args[]) {
		int[][] num = {{1, 4, 5}, {2, 6, 7}, {3, 8, 9}};
		search(num, 9);
	}

	public static void search(int[][] num, int k) {
		int rows = num.length;
		int columns = num[0].length;

		boolean ifFound = false;
		// search start position
		int x = rows - 1;
		int y = 0;
		while(x >= 0 && y <= columns - 1) {
			if(num[x][y] > k)
				x--;
			else if(num[x][y] < k)
				y++;
			else {
				ifFound = true;
				System.out.println("Found " +k+" at: (" + x + "," + y + ")");
				break;
			}
		}

		if(ifFound==false)
			System.out.println("Not found");
	}
}
