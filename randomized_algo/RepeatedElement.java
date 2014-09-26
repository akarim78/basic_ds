/*
 * array A[n], n/2 elements distinct, n/2 repeated
 */
import java.util.Random;

public class RepeatedElement{

	static int ops = 0;
	public static void main(String[] args){
		int a[] = {1, 2, 7, 8, 3, 3, 3, 3};
		int rep = checkRepeated(a);
		System.out.println("Rep: " + rep + " Ops: " + ops);
		rep = checkRepeatedRand(a);
		System.out.println("Rep: " + rep + " Ops: " + ops);

	}

	public static int checkRepeated(int[] a){
		ops = 0;
		int n = a.length;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				ops ++;
				if(a[i] == a[j]){
					return a[i];
				}
			}
		}

		return -1;
	}

	public static int checkRepeatedRand(int[] a){
		int n = a.length;
		ops = 0;
		Random rg = new Random();
		while(true) {
			ops ++;
			int i = rg.nextInt(n);
			int j = rg.nextInt(n);
			if(i != j && a[i] == a[j]){
				return a[i];
			}
		}
	}
}
