/*
 * Replace all spaces with %20
 * assumption: sufficient space
 * 
 */

public class Problem4 {

	public static void main(String args[]) {
		String s = "how many roads";
		String res = replace(s);
		System.out.println(res);
	}

	public static String replace(String s) {
		// ------------------
		int spaceCount = 0;
		int length = s.length();
		int newLength = 0;
		char[] str = s.toCharArray();
		for(int i = 0; i < length; i++) {
			if(str[i] == ' ') {
				spaceCount ++;
			}
		}
		newLength = length + 2 * spaceCount;
		//-----------
		char[] res = new char[newLength];
		for(int i =0; i < length; i++) {
			res[i] = str[i];
		}
		//----------
		for(int i = length-1; i >= 0; i--) {
			if(str[i] == ' ') {
				res[newLength - 1]  = '0';
				res[newLength - 2]  = '2';
				res[newLength - 3]  = '%';
				newLength = newLength - 3;
			} else{
				res[newLength-1] = str[i];
				newLength --;
			}
		}


		//----------
		return new String(res);
	}
}
