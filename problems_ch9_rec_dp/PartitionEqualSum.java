/*
 * partition min sum equal recursive and DP
 */

public class PartitionEqualSum {

	public static void main(String args[]){
		int[] data = {4, 3, 1, 2};
		// O(n lg(n))
		//Sort.quickSort(data, 0, data.length - 1);
		//boolean isEqual = findPartition(data, data.length);
		boolean isEqual = findPartitionDP(data, data.length);
		System.out.println("Result: " + isEqual);		

		/*for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}*/
	}

	public static boolean findPartitionDP(int[] a, int n) {
		// sum
                int sum = 0;
                for(int i = 0; i < n; i++){
                        sum += a[i];
                }
	        if((sum%2) != 0) return false;

		boolean part[][] = new boolean[sum/2 + 1][n + 1];
		for(int i = 0; i <= n; i++){
			part[0][i] = true;
		}

		for(int i = 1; i <= sum/2; i++) {
			part[i][0] = false;
		}

		for(int i = 1; i <= sum/2; i++){
			for(int j = 1; j<= n; j++){
				part[i][j] = part[i][j-1];
				if(i >= a[j-1]) {
					part[i][j] = part[i][j] || part[i - a[j-1]][j-1];
				}
				//System.out.print( part[i][j]+"\t");
			}
			//System.out.println();
		}
		for(int i = 0; i <= sum/2; i++){
                        for(int j = 0; j<= n; j++){
				System.out.print( part[i][j]+"\t");
			}
			System.out.println();
		}
		
		return part[sum/2][n];

	}

	public static boolean findPartition(int[] a, int n) {
		// sum
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum += a[i];
		}	

		if((sum%2) != 0) return false;
		return isSubsetSum(a, n, sum/2);
	}

	public static boolean isSubsetSum(int[] a, int n, int sum) {
		for(int i = 0; i < n; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("n:"+ n + " sum: "+sum);
		// base cases
		if(sum == 0) return true;
		if(n == 0 && sum != 0) return false;
		
		// if last element greater than sum then ignore it
		if(a[n-1] > sum) return isSubsetSum(a, n-1, sum);
		boolean x = isSubsetSum(a, n-1, sum);
		boolean y = isSubsetSum(a, n-1, sum - a[n-1]);
		System.out.println("X: "+x+" Y: "+y);
		return x || y;
	}

}
