public class PairSumSortedArray {

	public static void main(String args[]) {
		int M = 12;
		int[] arr = {1, 3, 4, 6, 7, 9, 10, 11};
		printPair(arr, M);
	}

	public static void printPair(int[] arr, int M) {
		int left = 0;
		int right = arr.length - 1;

		while(left < right) {
			if((arr[left] + arr[right]) == M) {
				System.out.println(arr[left] + " " +arr[right]);
				left ++;
				right --;
			}else if ((arr[left] + arr[right]) == M) {
				left ++;
			}else {
				right --;
			}

		}

	}


}
