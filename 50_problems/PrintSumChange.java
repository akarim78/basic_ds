public class PrintSumChange {

	public static void main(String args[]) {
		int[] coins = {25, 10, 5, 1};
		int[] counts = new int[coins.length];
		printChanges(coins, counts, 0, 36);
	}

	public static void printChanges(int[] coins, int[] counts, int startIndex, int totalAmount) {
		if(startIndex >= coins.length) {
			System.out.print("Amount: "+totalAmount);
			for(int i = 0; i < coins.length; i++) {
				System.out.print(counts[i] + " * " + coins[i] + "+");
			}
			System.out.println();
			return;
		}

		if(startIndex == coins.length - 1) {
			if(totalAmount % coins[startIndex] == 0) {
				counts[startIndex] = totalAmount/coins[startIndex];
				printChanges(coins, counts, startIndex+1, 0);
			}
		} else{
			for(int i = 0; i <= totalAmount/coins[startIndex]; i++){
				counts[startIndex] = i;
				printChanges(coins, counts, startIndex + 1, totalAmount - coins[startIndex]*i );
			}
		}
		
	}
}
