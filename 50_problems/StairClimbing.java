public class StairClimbing {

	public static void main(String args[]) {
		int x = 35;
		long startTime = System.currentTimeMillis();
		System.out.println("# ways: " + stClimbRec(x));
		System.out.println("Time took: "+ (System.currentTimeMillis() - startTime));
		//int[] table = new int[x + 1];
		/*table[0] = 0;
		table[1] = 1;
		table[2] = 2;
		table[3] = 4;*/
		startTime = System.currentTimeMillis();
		System.out.println("# ways: " + stClimbIt(x));
		System.out.println("Time took: " + (System.currentTimeMillis() - startTime));
	}

	public static int stClimbRec(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		return stClimbRec(n-1) + stClimbRec(n-2) + stClimbRec(n-3);
	}

	public static int stClimbIt(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		int[] prev = {1, 2, 4};
		// comes here for n > 3
		int current = 3;
		while (current < n) {
			int preTotal = prev[0]+prev[1]+prev[2];
			prev[0] = prev[1];
			prev[1] = prev[2];
			prev[2] = preTotal;
			current ++;
		}
		
		return prev[2];

	} 
}
