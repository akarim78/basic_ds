/*
 * Count occurance of a number in a sorted array
 * divide and conquer (binary search does not give occurance)
 */
public class CountOccuranceProblem {
	public static void main(String args[]) {

		int[] arr = {1, 2, 2, 2, 3, 4, 5, 6, 7};
		int count = countOccurance(arr, 2, 0, arr.length - 1);
		System.out.println("Occurance of 2 : " + count);

	}

	public static int countOccurance(int[] arr, int x, int startIndex, int endIndex) {
		// need to determine when the recursive method stop
		if(endIndex < startIndex) return 0;
		// before binary search find the subarray
		if(arr[startIndex] > x || arr[endIndex] < x) return 0;
		if(arr[startIndex] == x && arr[endIndex] == x)
			return endIndex - startIndex + 1; // if all elements

		int midInd = (startIndex + endIndex) /2;
		if(arr[midInd] == x)
			return 1 + countOccurance(arr, x, startIndex, midInd - 1)
				+ countOccurance(arr, x, midInd + 1, endIndex);
		else if(arr[midInd] > x)
			return countOccurance(arr, x, startIndex, midInd - 1);
		else
			return countOccurance(arr, x, midInd + 1, endIndex);
	}
}

