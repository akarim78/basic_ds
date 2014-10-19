public class LongestPalindrome {

	public static void main(String args[]) {
		String s = "5461233215";
		char[] chars = s.toCharArray();
		System.out.println("If Pal: " + isPalindrome(chars, 0, chars.length - 1));		
		System.out.println("Longest naive: " + longestPalindromeNaive(s));
		System.out.println("Longest improved: " + longestPalindrome(s));
	}

	public static String longestPalindrome(String in) {
		char[] input = in.toCharArray();

		int longestStart = 0;
		int longestEnd = 0;
		for(int mid = 0; mid < input.length; mid++) {
			int left = mid;
			int right = mid;
			while(left >= 0 && right < input.length) {
				if(input[left] == input[right]) {
					if(right - left > longestEnd -longestStart) {
						longestStart = left;
						longestEnd = right;
					}
				}
				left--;
				right++;
			}
			
			left = mid;
			right = mid + 1;
			while(left >= 0 && right < input.length){
				if(input[left] == input[right]) {
					if(right - left > longestEnd - longestStart) {
						longestStart = left;
						longestEnd = right;
					}
				}
				left--;
				right++;
			}
			
		}
		return in.substring(longestStart, longestEnd + 1);
	}

	public static String longestPalindromeNaive(String in) {
		char[] input = in.toCharArray();
		int longestStart = 0;
		int longestEnd = 0;

		for(int start = 0; start < input.length; start ++) {
			for(int end = start + 1; end <= input.length; end ++) {
				if(isPalindrome(input, start, end-1)) {
					if((end-start) > (longestEnd - longestStart)){
						longestStart = start;
						longestEnd = end;
					}
	
				}
				
			}
		}

		return in.substring(longestStart, longestEnd);
	}
		
	// check if palindrome
	public static boolean isPalindrome(char[] input, int start, int end) {
		for(int i = start; i <= (start+end)/2; i++) {
			if(input[i] == input[start + end -i]) continue;
			else return false;
		}
		return true;
	}
}
