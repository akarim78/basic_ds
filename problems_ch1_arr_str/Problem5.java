/*
 * String compression aabcccccaaa -> a2b1c5a3
 *
 */

public class Problem5 {

	public static void main(String args[]) {
		String str = "aaabcccccaaa";
		String res = compress1(str);
		System.out.println(res);

	}

	public static String compress1(String str) {
		String res = "";
		char last = str.charAt(0);
		int count = 1;

		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;
			} else{
				res += last + "" +count;
				last = str.charAt(i);
				count = 1;
			}
		}	
		return res + last + count;
	}

	public static String compress(String str) {
		
		return "";
	}
}
