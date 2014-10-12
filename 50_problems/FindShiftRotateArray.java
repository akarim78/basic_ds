public class FindShiftRotateArray{
	
	public static void main(String args[]) {
		int[] nums = {5, 6, 8, 9, 13, 1, 2, 4};
		int shift = findShift(nums);
		System.out.println("Index: " + shift);

	}

	public static int findShift(int[] num) {
		int start = 0;
		int end = num.length - 1;

		while(start <= end){
			if(num[start] < num[end]){ 
				return end + 1;
			} else{
				// find which side is not sorted
                		int mid = (start+end) / 2;
                		if(num[start] <= num[mid] && num[mid] <= num[end]) {
					return mid+1;
				} else if(num[start] <= num[mid]) {
					start = mid +1;
				} else {
					end = mid - 1;
				}
			}
		}


		return -1;
	}
}
