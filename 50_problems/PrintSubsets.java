public class PrintSubsets {
	public static void main(String args[]) {
		int[] nums = {1, 2, 3};
		printAllSubsets(nums);
	}

	public static void printAllSubsets(int[] nums) {
		for(int i = 0; i <= nums.length; i++) {
			boolean[] ifPrint = new boolean[nums.length];
			printAllSubsets(nums, ifPrint, 0, i);
		}

	}

	public static void printAllSubsets(int[] nums, boolean[] ifPrint, int start, int remain) {
		if(remain == 0) {
			System.out.print("Start: " + start + "--");
			for(int i = 0; i < ifPrint.length; i++) {
				if(ifPrint[i]) {
					System.out.print(nums[i] + " ");
				}
			}
			System.out.println();
		} else{
			if(start + remain > nums.length);
			else{
				for(int i = start; i< nums.length; i++) {
					if(ifPrint[i] == false) {
						ifPrint[i] = true;
						printAllSubsets(nums, ifPrint, i + 1, remain - 1 );
						ifPrint[i] = false;
					}
				}
			}
		}

	}
}
