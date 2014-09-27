/*
 * partition min sum diff equal DP
 */

public class PartitionMinSumDiff{
	static int lSum = 0;
	static int rSum = 0;
	public static void main(String args[]){
		int[] data = {4, 3, 1, 9, 2, 5, 6, 7, 100, 8};
		// O(n lg(n))
		Sort.quickSort(data, 0, data.length - 1);
		
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}

		int[] partition = new int[data.length];
		partition(data, partition);
		
		for(int i = 0; i < partition.length; i++){
                        System.out.print(partition[i] + " ");
                }  
		System.out.println("Left: " + lSum +" Right: " + rSum + " = "+ (lSum - rSum));

	}

	public static void partition(int[] data, int[] par){
	
	}

}
