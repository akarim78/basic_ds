public class PrintInterleavings {
	static int count = 0;
	public static void main(String args[]) {
		String s1 = "ABC";
		String s2 = "DEF";
		printInterleavings(s1, s2);
		System.out.println("Count: "+count);
	}

	public static void printInterleavings(String s1, String s2) {
		printInterleavings(s1, s2, "");
	}

	public static void printInterleavings(String s1, String s2, String soFar) {
		if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0)) {
			return;
		}

		if(s1 == null || s1.length() == 0) {
			System.out.println("s2-- "+s2 + "--" + soFar + s2 + " ");
			count++;
			return;
		}

		if(s2 == null || s2.length() == 0) {
			System.out.println("s1-- "+ s1+ "--" + soFar + s1 + " ");
			count++;
			return;
		}

		printInterleavings(s1.substring(1), s2, soFar + s1.charAt(0));
		printInterleavings(s1, s2.substring(1), soFar + s2.charAt(0));
	}
}
