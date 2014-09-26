public class FindMinMax {

	static int min = 0;
	static int max = 0;
	//static int max1 = 0;
	//static int min1 =0;
	static int[] a = {1, 5, 3, 7, 2, 9};
	public static void main(String args[]) {
		findMinMax(0, a.length - 1);
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);	
	}

	public static void findMinMax(int i, int j) {
		if(i == j) 
			max = min = a[i];
		else if (i == j-1) {
			if(a[i] < a[j]){
				max = a[j];
				min = a[i];
			}else {
				max = a[i];
				min = a[j];
			}
		} else{
			int mid = (i + j )/2;
			findMinMax(i, mid);//, min, max);
			int min1 = min;
			int max1 = max;
			findMinMax(mid + 1, j);//, min1, max1);
			if(max < max1) max = max1;
			if(min > min1) min = min1;
		}	
	}	
}
