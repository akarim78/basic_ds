public class MaxSubseqSum {


	public static void main(String args[]) {
		int[] nums = new int[10];
		java.util.Random myRandom = new java.util.Random();
		for(int i = 0; i < nums.length; i++) {
			nums[i] = myRandom.nextInt(20) - 10;
			System.out.print(nums[i] + " ");
		}

		System.out.println("\nMax sum: " + maxSubseqSum(nums));

	}

	public static int maxSubseqSum(int[] num) {
		int tempSum = 0;
		int maxSum = 0;
		int maxSumStart = 0;
		int maxSumEnd = 0;
		int tempSumStart = 0;

		for(int i = 0; i < num.length; i++) {

			int futureSum = tempSum + num[i];
			if(futureSum > 0) {
				tempSum = futureSum;
				if(tempSum > maxSum) {
					maxSum = futureSum;
					maxSumStart = tempSumStart;
					maxSumEnd = i;
				}
			} else{
				tempSum = 0;
				tempSumStart = i+1;
			}
		}

		System.out.println("Start: " + maxSumStart + " End: " + maxSumEnd);
		return maxSum;

	}
}
