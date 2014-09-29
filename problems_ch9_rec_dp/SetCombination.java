public class SetCombination{

	static char[] set = {'a', 'b', 'c', 'd'};
	public static void main(String args[]){
		int[] a = new int[set.length];
		combination(a, 0, a.length - 1);

	}

	public static void combination(int[] a, int k, int n){
		if(k == n) {
			a[k] = 0;
			print(a, n);
			a[k] = 1;
			print(a, n);
			return;
		}

		a[k] = 0;
		combination(a, k+1, n);
		a[k] = 1;
		combination(a, k+1, n);
	} 

	public static void print(int[] a, int n){
		int sum = 0;
		for(int i = 0; i <= n; i++){
			if(a[i] == 1) {
				System.out.print(set[i] + " ");
				sum ++;
			}
		}
		System.out.println();
		if(sum == 0){
			// null set
			System.out.println("Null Set");
		}
	
	}
}
