public class FirstIndexSorted{

	public static void main(String args[]) {
		int[] arr = {1, 2, 2, 3, 3, 3, 4, 5};
		int index = getIndex(arr, 5, 0, arr.length-1);
		System.out.println("First Index of 3: " + index);
	}

	public static int getIndex(int[] arr, int x, int beginInd, int endInd) {
		// terminal condtion
		if(endInd < beginInd) {
			return -1;
		}

		if(arr[beginInd] > x) return -1;
		if(arr[endInd] < x) return -1;

		int midInd = (beginInd + endInd) / 2;
		if(arr[midInd] == x && (midInd==0 || arr[midInd - 1] < x))
			return midInd;
		else if(arr[midInd] == x && (midInd==0 || arr[midInd - 1] == x))
			return getIndex(arr, x, beginInd, midInd - 1);
		else if(arr[midInd] > x)
			return getIndex(arr, x, beginInd, midInd - 1);
		else
			return getIndex(arr, x, midInd + 1, endInd);
	

	}
}
