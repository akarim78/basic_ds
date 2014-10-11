public class MergeSortedArrays{

	public static void main(String args[]) {
		int[] a = {1, 5, 8, 9, 0, 0, 0};
		int[] b = {2, 6, 10};
		int p = 4;
		int q = b.length;
		merge(a, b, p, q);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();

	}

	public static void merge(int[] a, int[] b, int sizea, int sizeb) {
		int counta = sizea - 1;
		int countb = sizeb - 1;
		while(countb >= 0) {
			if(a[counta] >= b[countb]){
				a[counta + countb + 1] = a[counta];
				counta --;
			} else{
				a[counta + countb + 1] = b[countb];
				countb --;
			}
		}
		

	}

	
}
