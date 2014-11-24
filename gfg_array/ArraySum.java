/*
 * given an array A[] of n numbers and another number x, 
 * determines whether or not there exist two 
 * elements in S whose sum is exactly x
 */

import java.util.Arrays;
import java.util.HashMap;

public class ArraySum {
	public static void main(String args[]) {
		int[] nums = {1, 4, 24, 45, 6, 10, -8, 15, 12};
		int k = 16;

		// solution 1;
		System.out.println("Solution 1");
		arrayElementsSum(nums, k);

		// solution 2:
		System.out.println("Solution 2");
		arrayElementsSumHM(nums, k);
	}

	// solution 2
	// using hashmap
	public static void arrayElementsSumHM(int[] nums, int x) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			int temp = x - nums[i];
			// problem with map			
			if(map.containsKey(temp)) {
				System.out.println(temp + " + " + nums[i]);
			} else {
				//System.out.println("Hello");
				map.put(nums[i], nums[i]);
			}
		}
	}

	// solution 1
	// sort (n logn)
	public static void arrayElementsSum(int[] nums, int x) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			if(nums[left] + nums[right] == x) {
				System.out.println(nums[left] + " + " + nums[right]);
				left ++;
				right --;
			} else if(nums[left] + nums[right] < x) {
				left ++;
			} else {
				right --;
			}

		}

	}

}
