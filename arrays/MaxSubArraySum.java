public class MaxSubArraySum {

	public static void main(String args[]) {
		int[] a = {-1, -3, -4,-3, -2, -2, -5, -3, 8, -5, -3};
		int max = maxSubArraySum(a, a.length);
		System.out.println("Max: " + max);

		max = maxSum(a, a.length);
		System.out.println("max: " + max);
	}

	public static int maxSubArraySum(int[] nums, int count) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int start = 0;
		int end = 0;
		int temp = 0;
		for(int i = 0; i < count; i++) {
			maxEndingHere += nums[i];
			if(maxEndingHere < 0) {
				start = i+1;
				end = i+1;
				maxEndingHere = 0;

			}
			if(maxSoFar < maxEndingHere){ 
				maxSoFar = maxEndingHere;
				end = i;
			}
		}

		System.out.println("Max: " + maxSoFar + " start: " + start + " end: " + end);
		return maxSoFar;

	}

	public static int max(int x, int y){
		if(x > y) return x;
		return y;
	}

	public static int maxSum(int[] nums, int count) {
		int maxSoFar = nums[0];
		int curMax = nums[0];
		int start = 0;
		int end = 0;

		for(int i = 1; i< count; i++){
			if(nums[i] > maxSoFar + nums[i]){
				maxSoFar = nums[i];
				start = i;
			} else{
				maxSoFar = maxSoFar + nums[i];
			}

			if(curMax < maxSoFar) {
				curMax = maxSoFar;
				end = i;
			}
		}
		if(curMax < 0) start = end;
		System.out.println("Max: " + curMax + " Start: "+ start + " End: "+end);
		return curMax;
	}

}
