public class RotatedPalindrome {
	public static void main(String args[]) {
		String str = "1234321";
		System.out.println(str + " ? : "+isRotatedPalindrome(str));
		
		str = "3432112";
                System.out.println(str + " ? : "+isRotatedPalindrome(str));

	 	str = "4321124";
                System.out.println(str + " ? : "+isRotatedPalindrome(str));
	}

	public static boolean isPalindrome(String s) {
		char[] arr = s.toCharArray();
		for(int i = 0; i< arr.length; i++) {
			if(arr[i] != arr[arr.length-1-i]) return false;
		}
		return true;
	}

	public static boolean isRotatedPalindrome(String s) {
		for(int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if(isPalindrome(right+left))
				return true;
		}
		return false;
	}


}
