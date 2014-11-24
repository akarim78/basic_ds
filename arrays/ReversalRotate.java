public class ReversalRotate {

	public static void main(String args[]) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		reverseRotate(nums, 2, nums.length);
		for(int i = 0; i< nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}

	public static void reverseRotate(int[] nums, int d, int n) {
		reverse(nums, 0 , d-1);
		reverse(nums, d, n-1);
		reverse(nums, 0, n-1);

	}

	public static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
