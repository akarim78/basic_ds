public class SortingTest{
	
	public static void main(String args[]){
		int sorted[] = {5, 7, 3, 2, 1, 8, 4, 6, 9};
		//int sorted[] = Sort.mergeSort(unsorted);

		Sort.quickSort(sorted, 0, sorted.length-1);
		for(int i=0; i < sorted.length; i++)
			System.out.print(sorted[i] + " ");

		System.out.println();

		
	}

}
