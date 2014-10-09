public class StringPermutation {

	public static void main(String args[]) {
		String test = "123";
		char[] str = test.toCharArray();
		printPermutation(str, 0);

	}
	
	public static void printPermutation(char[] str, int currentFocus) {

		if(currentFocus == str.length - 1){
			System.out.println(new String(str));
			return;
		}

		printPermutation(str, currentFocus + 1);
		for(int i = currentFocus + 1; i < str.length; i++) {
			char temp = str[currentFocus];
			str[currentFocus] = str[i];
			str[i] = temp;

			printPermutation(str, currentFocus + 1);
		}
		
	}
}
