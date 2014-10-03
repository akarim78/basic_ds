/*
 * Decide whether 2 strs are permutation
 * ask- if case sensitive? 
 *      white space matters?
 */

import java.util.Arrays;

public class Problem3 {

	public static void main(String args[]) {
		String s = "god ";
		String t = " dog ";

		boolean perm = isPermutation1(s, t);
		System.out.println("Result: " + perm);
	}

	// clean, simple, easy
	public static boolean isPermutation(String s, String t) {
		if(s.length() != t.length()) return false;
		return sort(s).equals(sort(t));

	}

	public static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	// more efficient solution
	public static boolean isPermutation1(String s, String t) {
		if(s.length() != t.length()) return false;
		
		int[] letters = new int[256];
		char[] s_arr = s.toCharArray();
		for(char c: s_arr) {
			letters[c]++;
		}

		for(int i = 0; i< t.length(); i++) {
			int c = (int) t.charAt(i);
			if(--letters[c] < 0) return false;
		}
		return true;
	}
}
