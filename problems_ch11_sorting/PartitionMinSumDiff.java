/*
 * partition min sum diff equal Greedy
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
		System.out.println("Left Sum: " + lSum +" Right Sum: " + rSum + " Diff: "+ (lSum - rSum));

		partition = new int[data.length];
                partition1(data, partition);
 
                for(int i = 0; i < partition.length; i++){
                        System.out.print(partition[i] + " ");
                }
                System.out.println("Left Sum: " + lSum +" Right Sum: " + rSum + " Diff: "
+ (lSum - rSum)); 
	}

	public static int min(int a, int b) {
		if(a < b) return a;
		else return b;
	}

	public static int max(int a, int b) {
		if(a > b) return a;
		else return b;
	} 

	public static void partition(int[] data, int[] par){
                int n = data.length - 1;
                int left = 0;
                int right = n;
                int sumLeft = 0;
                int sumRight = 0;
                int count = data.length;
		int limit = data.length/2; 

                for(int i = count-1; i >= 0; i-=1) {
                        if(sumLeft <=  sumRight) {
				if(left < limit) {
					par[left] = data[i];
					sumLeft+= par[left++];
				}else {
					par[right] = data[i];
                                        sumRight+= par[right--]; 
				}
                        } else{
				if((n-right) < limit){
					par[right] = data[i];
                                        sumRight+= par[right--]; 
				} else{
					par[left] = data[i];
                                        sumLeft+= par[left++]; 
				}				

                        }
 
                }
 
                lSum = sumLeft;
                rSum = sumRight;
        }

	public static void partition2(int[] data, int[] par){
		int n = data.length - 1;
		int left = 0;
		int right = n;
		int sumLeft = 0;
		int sumRight = 0;
		int count = data.length;
		
		for(int i = count-1; i >= 0; i-=2) {
			if(sumLeft <=  sumRight) {
				if(i > 0) {
					par[left] = max(data[i], data[i - 1]);
					par[right] = min(data[i], data[i - 1]);
					sumLeft += par[left ++];
					sumRight += par[right --];
				} else{
					par[left] = data[i];
					sumLeft += par[left++];
				}
			} else{
 				if(i > 0) {
                                        par[right] = max(data[i], data[i - 1]);                          					par[left] = min(data[i], data[i - 1]);
					sumLeft += par[left ++];                                        
                                        sumRight += par[right --];
                                } else{
                                        par[right] = data[i];
                                        sumRight += par[right--];
                                }
			}

		}

		lSum = sumLeft;
		rSum = sumRight;
	}

	public static void partition1(int[] data, int[] par){
                int n = data.length - 1;
                int left = 0;
                int right = n;
                int sumLeft = 0;
                int sumRight = 0;
                int count = data.length - 1;
                while(count >= 0) {
                        if(sumLeft >= sumRight){
                                if(count > 0){
                                        par[left++] = data[count - 1];
                                        sumLeft += data[count - 1];
                                }
                                par[right--] = data[count];
                                sumRight += data[count];
                        } else{
                                if(count > 0){
                                        par[right--] = data[count - 1];
                                        sumRight += data[count - 1];
                                }
                                par[left++] = data[count];
                                sumLeft += data[count];
                        }
 
                        count -= 2;
                }
 
                lSum = sumLeft;
                rSum = sumRight;
        }
}
