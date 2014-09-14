/*
 * if a string has all unique characters w/o any data structure
 */

/*
 * Assumptions: fixed alphabet
 */

public class Problem1{

	public static void main(String args[]){
		String s1 = "child must either be a leaf node or the root of another binary";
		String s2 = "abcd";		
		System.out.println(isAllCharsUnique(s1));
		System.out.println(isAllCharsUnique(s2));
	}

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
}
