public class Partition{

	public static void main(String[] args){
		int[] data = {65, 70, 75, 85, 60, 55, 80, 90};
		partition(data);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] +" ");
		}
		System.out.println();

	}

	public static void partition(int[] a){
		int pivot = a[0];
		int left = 1;
		int right = a.length - 1;

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
		a[left-1] = a[0];
		a[0] = t;
	}
}
