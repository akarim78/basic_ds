public class ReversePhrase {

	public static void main(String args[]) {
		String phrase = "Hello World";
		char[] ph = phrase.toCharArray();
		
		reverse(ph, 0, ph.length - 1);
		for(int i = 0; i < ph.length; i++)
			System.out.print(ph[i] + " ");
		System.out.println();

		int wordStart = 0;
		for(int i = 0; i < ph.length; i++) {
			if(ph[i] == ' ') {
				reverse(ph, wordStart, i - 1);
				wordStart = i + 1;
			}
		}
		reverse(ph, wordStart, ph.length - 1);

		for(int i = 0; i < ph.length; i++)
			System.out.print(ph[i] + " ");
		System.out.println();
	}

	public static void reverse(char[] ch, int start, int end) {
		if(start >= end)
			return;

		int mid = (start + end)/2;
		for(int i = start; i <= mid; i++) {
			char temp = ch[i];
			ch[i] = ch[start + end - i];
			ch[start + end - i] = temp;			
		}
	}
}
