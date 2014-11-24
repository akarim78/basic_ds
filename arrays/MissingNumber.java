public class MissingNumber{

	public static void main(String args[]){
		int[] nums = {5, 4, 8, 6, 9};
		int m = missing(nums, nums.length, 4, 9);	
		System.out.println("Missing: " + m);
	}

	public static int missing(int[] nums, int size, int start, int end) {
		int sum = ((start+end)/2) * (end - start + 1);
		for(int i = 0; i < size; i++) {
			sum -= nums[i];
		}
		return sum;
	}
}

