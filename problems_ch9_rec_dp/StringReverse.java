public class StringReverse {

	public static void main(String args[]) {
		String test = "testing";
		String result = reverse(test);
		System.out.println("Reverse: "+ result);
	}

	public static String reverse(String s) {
		if(s.equals(""))
			return s;
		else {
			String rev = reverse(s.substring(1));
			return rev + s.charAt(0);
		}
	}
}
