/*
 * Reversing order of words in a sentence
 */

import java.util.StringTokenizer;

public class ReverseWords{

	public static void main(String args[]){
		String str = "hello how are you my friend";
		String res = reverse(str);
		System.out.println("Reversed: " + res);
		res = reverse2(str);
                System.out.println("Reversed: " + res);
	}

	public static String reverse(String str){
		Stack stack = new Stack();
		StringTokenizer tk = new StringTokenizer(str, " ");
		int count = tk.countTokens();
		while(tk.hasMoreTokens()){
			String temp = tk.nextToken();
			//System.out.println(temp);
			stack.push(temp);
		}

		//System.out.println(""+count);
		String result = "";
		for(int i = 0; i < count; i++){
			result += stack.pop().data+" ";
			//System.out.println(stack.pop().data);
		}

		return result;
		

	}

	public static String reverse2(String str){
		int size = str.length();
		char[] rev = new char[size];
		for(int i = 0; i < size; i++){
			rev[i] = str.charAt(size-i-1);
		}

		String revStr = new String(rev);
		StringTokenizer tk = new StringTokenizer(revStr, " ");
                int count = tk.countTokens();
                while(tk.hasMoreTokens()){
                        String temp = tk.nextToken();
                        //System.out.println(temp);
                        //stack.push(temp);
			for(int i = temp.length()-1; i>= 0; i--){
				System.out.print(temp.charAt(i));
			}
			System.out.print(" ");
                }

		return revStr;

	} 
}
