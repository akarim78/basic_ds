/*
 * String permutation recursive
 */

public class StringPermutation { 

	public static void main(String args[]) {
		int[] data = {1, 2, 3, 4};
		perm(data, 0, data.length - 1);	
	}

	public static void perm(int[] a, int k, int n) {
		if(k == n){
			printArray(a);
		} else{
			for(int i = k; i <= n; i++) {
				swap(a, i, k);
				perm(a, k + 1, n);
				swap(a, i, k);
			}
		}
	}

	public static void printArray(int[] a) { 
		for(int i = 0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void swap(int[] a, int p, int q) {
		int t = a[q];
		a[q] = a[p];
		a[p] = t;
	}
}

