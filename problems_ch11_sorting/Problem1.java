/*
 * Merging sorted A and B
 * A has space for B
 */
public class Problem1{

	public static void main(String args[]){
		int[] a = new int[10];
		a[0] = 1;
		a[1] = 3;
		a[2] = 5;
		a[3] = 7;
		a[4] = 9;
		int[] b = {2, 4, 6, 8, 10};

		merge(a, b);
		for(int i = 0; i < 10; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
 
	}

	public static void merge(int[] p, int[] q){		
		int tlp = p.length;
		int lq = q.length;
		int lp = tlp - lq;
		
		int indexA = lp - 1;
		int indexB = lq - 1;
	 	int indexMerged = tlp -1;	
		while(indexB >= 0){
			if(indexA >= 0 && p[indexA] > q[indexB]){
				p[indexMerged] = p[indexA];
				indexA--;
			} else{
				p[indexMerged] = q[indexB];
				indexB--;
			}
			indexMerged --;
		}

	}
}
