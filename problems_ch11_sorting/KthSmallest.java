public class KthSmallest{

	public static void main(String[] args){
		int[] data = {65, 70, 75, 85, 60, 55, 80, 90};
		//int ele = kthSmallest(data, 3);
		for(int i = 0; i < data.length; i++){
			int ele = kthSmallest(data, i);
			System.out.println("Kth Smallest: " + ele);
		}
	}

	public static int kthSmallest(int[] a, int k) {
		
		int left = 0;
		int right = a.length - 1;
		int j;
		do{
			j = partition(a, left, right);
			//System.out.println("J " + j);
			if(j == k) return a[j];
			else if (k < j) right = j - 1;
			else left = j + 1;
		} while(true);

	}

	public static int partition(int[] a, int left, int right){
		int pivot = a[left];
		int pPosition = left;

		left ++;
		while(left <= right){
			if(a[left] > pivot && a[right] < pivot){
				int t = a[left];
				a[left] = a[right];
				a[right] = t;
				left ++;
				right --;
			} 
			if(a[left] < pivot){ 
				left++;
			}
			if(a[right] > pivot){
				right --;
			}
			
		}
		int t = a[left-1];
		a[left-1] = a[pPosition];
		a[pPosition] = t;
		return (left - 1);
	}
}
