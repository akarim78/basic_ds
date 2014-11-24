public class RotateArray {

	public static void main(String args[]) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		rotate(nums, 2, nums.length);
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}

	// time = O(n)
	// space = O(d)
	public static void rotate(int[] nums, int d, int n) {
		int[] temp = new int[d];
		for(int i = 0; i < d; i++)
			temp[i] = nums[i];
		for(int i = d; i < n; i++)
			nums[i-d] = nums[i];
		for(int i = 0; i < d; i++)
			nums[n-d+i] = temp[i];
	}

	// one by one time = O(nd) space = O(1)

	// 
}
