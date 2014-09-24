/*
 * sorted array rotated n number of times. finding the index of a value
 */

public class Problem3{

	public static void main(String args[]){
		int[] data = {19, 20, 25, 1, 3, 4, 5};
		int pos = findElement(data, 0, data.length - 1, 19);
		System.out.println("Position: " + pos);
		pos = findElement(data, 0, data.length - 1, 20); 
                System.out.println("Position: " + pos);      
		pos = findElement(data, 0, data.length - 1, 25); 
                System.out.println("Position: " + pos);      
		pos = findElement(data, 0, data.length - 1, 1); 
                System.out.println("Position: " + pos);     
		pos = findElement(data, 0, data.length - 1, 3);
                System.out.println("Position: " + pos);
                pos = findElement(data, 0, data.length - 1, 4);
                System.out.println("Position: " + pos);
                pos = findElement(data, 0, data.length - 1, 5); 
                System.out.println("Position: " + pos);   
	}

	public static int findElement(int[] a, int left, int right, int x){
		int mid =  (left + right) / 2;
		if(x == a[mid]){
			return mid;
		}

		if(right < left){
			return -1;
		}

		/*
		 * Either left or right is ordered properly. Need to find out.
		 * use that info
		 */
		if(a[left] < a[mid]){  // left ordered
			if(x >= a[left] && x <= a[mid]){
				return findElement(a, left, mid - 1, x); // search left
			} else{
				return findElement(a, mid + 1, right, x); // search right
			}
		} else if(a[left] > a[mid]){ // right properly ordered
			if(x >= a[mid] && x <= a[right]){
				return findElement(a, mid + 1, right, x); // search right
			} else{
				return findElement(a, left, mid - 1, x); // search left
			} 
		} else if(a[left] == a[mid]){ // repeats
			if(a[mid] != a[right]){// question
				return findElement(a, mid + 1, right, x);	
			}else{
				// else search both
				int result = findElement(a, left, mid - 1, x);
				if(result == -1){
					return findElement(a, mid + 1, right, x);
				} else{
					return result;
				}
			}
		}

		return -1;
	}	
}
