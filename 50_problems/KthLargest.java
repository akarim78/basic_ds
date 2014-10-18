public class KthLargest {
	
	public static void main(String args[]) {
		int[] num = {1, 8, 3, 6, 4, 9, 7, 2, 5};
		int kth = kthLargest(num, 4);
		System.out.println("kth largest: " + kth);
	}

	public static int kthLargest(int[] num, int k) {
		if(k < 1 || k > num.length)
			return -1;
		return kthLargest(num, 0, num.length-1, k);
	}

	public static int kthLargest(int[] num, int start, int end, int k) {
		int pivot = start;
		int left = start;
		int right = end;
		while(left <= right) {
			while(left <= right && num[left] <= num[pivot])
				++left;
			while(left <= right && num[right] >= num[pivot])
				--right;
			if(left < right){
				swap(num, left, right);
			}	
		}
		swap(num, pivot, right);
		if(k == right + 1)
			return num[right];
		else if(k < right + 1) 
			return kthLargest(num, start, right - 1, k);
		else
			return kthLargest(num, right + 1, end, k);

	}

	public static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
