public class Sort{

	public static void quickSort(int a[], int start, int end){
		if(start >= end)
			return;
		int pIndex = partition(a, start, end);
		quickSort(a, start, pIndex-1);
		quickSort(a, pIndex+1, end);
	}

	private static int partition(int a[], int start, int end){
		int pivot = a[end];
		int pIndex = start;
		for(int i = start; i<= end-1; i++){
			if(a[i] <= pivot){
				swap(a, i, pIndex);
				pIndex++;
			}
		}
		swap(a, pIndex,  end);
		
		return pIndex;
	}

	private static void swap(int a[], int a1, int a2){
		int temp = a[a1];
		a[a1] = a[a2];
		a[a2] = temp;
	}

	public static int[] mergeSort(int a[]){
		int n = a.length;
		if(n < 2)
			return a;

		int mid = (int)(n/2);
		
		int left[] = new int[mid];
		int right[] = new int[n - mid];

		for(int i = 0; i < mid; i++){
			left[i] = a[i];
		}

		for(int j = mid; j < n; j++){
			right[j - mid] = a[j];
		}

		mergeSort(left);
		mergeSort(right);
		a = merge(left, right, a);
		return a;
	}

	private static int[] merge(int left[], int right[], int a[]){
		int nl = left.length;
		int nr = right.length;
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < nl && j < nr){
			if(left[i] <= right [j]){
				a[k++] = left[i++];
				//k++;
				//i++;
			} else{
				a[k++] = right[j++];
				//k++;
				//j++;
			}
		}
		
		while(i < nl){
			a[k++] = left[i++];
			//k++;
			//i++;
		}

		while(j < nr){
			a[k++] = right[j++];
			//k++;
			//j++;
		}
		return a;

	}
}
