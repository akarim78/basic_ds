/*
 * n step, 1, 2, 3 hops
 */

public class Problem1{
	public static void main(String args[]){

		for(int i = 1; i < 15; i++){
			int c = hopsCombRec(i);
			System.out.println("Steps count: "+ i +" Comninaton count: " + c);
		}

		int map[] = new int[16];
		for(int i=0; i<16; i++) {
			map[i] = -1;
		}

		for(int i = 1; i < 15; i++){
                        int c = hopsCombDP(i, map);
                        System.out.println("Steps count: "+ i +" Comninaton count: " + c);
                }
	}

	public static int hopsCombRec(int n){
		if(n < 0) return 0;
		else if(n == 0) return 1;
		else return hopsCombRec(n-1) + hopsCombRec(n-2) + hopsCombRec(n-3);
	}

	public static int hopsCombDP(int n, int[] map){
		if(n < 0) return 0;
		else if(n == 0) return 1;
		else if(map[n] > -1) return map[n];
		else {
			map[n] = hopsCombDP(n-1, map) + hopsCombDP(n-2, map) + hopsCombDP(n-3, map);
			return map[n];
		}
	}
}
		
