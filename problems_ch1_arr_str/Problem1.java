/*
 * if a string has all unique characters w/o any data structure
 */

/*
 * Assumptions: fixed alphabet
 */

/*
 * alternative 1: N^2 solution
 * alternative 2: n logn sorting and then compraring with adjacent
 */

public class Problem1{

	public static void main(String args[]){
		String s1 = "child must either be a leaf node or the root of another binary";
		String s2 = "abcd";		
		System.out.println(isUniqueChar2(s1));
		System.out.println(isUniqueChar2(s2));
	}

	// space O(1) time O(n^2)
	public static boolean isAllCharsUnique(String s){
		for(char i = 'a'; i<='z'; i++){
			boolean found = false;
			for(int j=0; j<s.length(); j++){
				if(s.charAt(j) == i && found == true){
					return false;
				}else if(s.charAt(j) == i && found ==false){
					found = true;
				}
			}
		}
		return true;
	}

	// considering only a-z
	public static boolean isUniqueChar2(String str) {
		int checker = 0;
		for(int i = 0; i< str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1<< val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}

		return true;
	}

	// space O(1) time O(n)
	public static boolean isUniqueChar(String str) {
		if(str.length() > 256) return false; //pegionhole principle
		boolean[] char_set = new boolean[256];

		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val] == true) return false;
			char_set[val] = true;
		}
		return true;
	}
}
